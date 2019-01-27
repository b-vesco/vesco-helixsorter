package com.benvesco.vesco_helixsorter;

import com.benvesco.vesco_helixsorter.model.DspNode;
import com.benvesco.vesco_helixsorter.model.HlxPatchFile;
import com.benvesco.vesco_helixsorter.util.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Set;

/**
 * Main entry point of the app to sort Helix patch files by amp model.
 *
 * @author bvesco
 */
public class App {
    /** This is the sub-directory where the sorted files will go */
    private static final String SORTED_SUBDIR = "sorted";

    /** All amp models start with this prefix */
    private static final String AMP_PREFIX = "HD2_Amp";

    /** All amp models start with this prefix */
    private static final String PREAMP_PREFIX = "HD2_Preamp";

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final WildcardFileFilter hlxFilter = new WildcardFileFilter("*.hlx", IOCase.INSENSITIVE);

    public static void main(String[] args) {
        File baseDir;
        if (args.length == 0) {
            baseDir = new File(".");
        } else {
            baseDir = new File(FilenameUtils.getFullPath(args[0]), FilenameUtils.getName(args[0]));
        }
        logger.info("input directory {}", baseDir.getAbsolutePath());
        File copyDir = getSubDir(baseDir, SORTED_SUBDIR);
        logger.info("output directory {}", copyDir.getAbsolutePath());
        traverse(baseDir, copyDir);
        logger.info("Done!");
    }

    /**
     * Recursively traverse directory and all sub-directories looking for Helix
     * patch files.
     *
     * @param dir     The current directory to be searched.
     * @param copyDir The directory that will hold copies of the patch files.
     */
    private static void traverse(File dir, File copyDir) {
        File[] subdirs = dir.listFiles((FilenameFilter) DirectoryFileFilter.INSTANCE);
        if (subdirs == null) {
            logger.info("Moving on. No subdirectories found in {}", dir.getAbsolutePath());
            subdirs = new File[]{};
        }
        for (File subdir : subdirs) {
            if (SORTED_SUBDIR.equals(subdir.getName()))
                continue;
            traverse(subdir, copyDir);
        }

        File[] hlxFiles = dir.listFiles((FilenameFilter) hlxFilter);
        if (hlxFiles == null) {
            logger.info("Moving on. No *.hlx files found in {}", dir.getAbsolutePath());
            hlxFiles = new File[]{};
        }
        for (File hlxFile : hlxFiles) {
            logger.info("processing {}", hlxFile.getName());
            HlxPatchFile patch = Json.toPojo(hlxFile, HlxPatchFile.class);
            Set<String> models = getUsedModelsFrom(patch);
            if (models.isEmpty()) {
                logger.warn("\txxxxxx no amps found!!!");
            }
            for (String model : models) {
                File modelDir = getSubDir(copyDir, model);
                String newFilename = (models.size() == 1) ? hlxFile.getName() : "_" + hlxFile.getName();
                File destFile = new File(modelDir, newFilename);
                try {
                    FileUtils.copyFile(hlxFile, destFile);
                    logger.info("\t-----> copied to {}", modelDir);
                } catch (IOException e) {
                    logger.error("unable to copy file " + hlxFile.getName(), e);
                }
            }
        }
    }

    private static File getSubDir(File parent, String child) {
        if (child.startsWith(AMP_PREFIX)) {
            child = child.substring(AMP_PREFIX.length());
        }
        if (child.startsWith(PREAMP_PREFIX)) {
            child = child.substring(PREAMP_PREFIX.length());
        }
        File subDir = new File(parent, child);
        if (!subDir.exists()) {
            if (!subDir.mkdir()) {
                throw new RuntimeException("Failed to create a subdirectory in " + subDir.getAbsolutePath());
            }
        }
        return subDir;
    }

    /**
     * Determine all the used amp models in this patch and return them as a set.
     * Any patch can contain zero or more amp models and may contain the same
     * amp model multiple times.
     *
     * @param patch The patch file to traverse and search for amp models.
     * @return A set containing all unique amp models found in the patch.
     */
    private static Set<String> getUsedModelsFrom(HlxPatchFile patch) {
        Set<String> dsp1models = getUsedModelsFrom(patch.data.tone.dsp0);
        Set<String> dsp2models = getUsedModelsFrom(patch.data.tone.dsp1);

        Set<String> allModels = Sets.newHashSet(dsp1models);
        allModels.addAll(dsp2models);
        return allModels;
    }

    /**
     * Like {@link #getUsedModelsFrom(HlxPatchFile)} but for the DSP nodes.
     *
     * @param dsp The DSP node to search for amp models.
     * @return See return value for {@link #getUsedModelsFrom(HlxPatchFile)}
     */
    private static Set<String> getUsedModelsFrom(DspNode dsp) {
        Set<String> models = Sets.newHashSet();

        for (JsonNode possibleBlockNode : dsp.getExtraFields().values()) {
            JsonNode modelNode = possibleBlockNode.get("@model");
            if ((modelNode == null) || modelNode.isNull()) {
                continue;
            }
            if (!modelNode.isTextual()) {
                logger.error("found @model that is not a text value: {}", modelNode.toString());
            }
            String modelValue = modelNode.asText("failsauce");
            if (modelValue.startsWith(AMP_PREFIX)) {
                models.add(modelValue);
            }
            if (modelValue.startsWith(PREAMP_PREFIX)) {
                models.add(modelValue);
            }
        }

        return models;
    }
}
