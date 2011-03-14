package com.serb.io;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class should rename all java files and add package
 * User: S.Bezuglyi
 * Date: Mar 10, 2011
 */
public class AddPackages {

    private static final String START_SEARCH_DIR = "/home/S.Bezuglyi/IdeaProjects/thinkingInJava";
    private static final String PACKAGE_WORD = "package ";
    public static final Pattern PACKAGE_WORD_PATTERN = Pattern.compile(PACKAGE_WORD + "\\*");


    static class JavaFilesFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".java"));
        }
    }
    //TODO: may be recursive find 

    public static void main(String[] args) {

        File startDir = new File(START_SEARCH_DIR);
        File[] filesInDir = startDir.listFiles();
        if (!startDir.isDirectory() || !startDir.exists()) {
            throw new IllegalArgumentException("Start directory does not exists: " + startDir.getAbsolutePath());
        }

        for (File f : filesInDir) {
            File[] javaFiles = f.listFiles(new JavaFilesFilter());
            if (javaFiles != null) {
                String packageName = f.getName();
                for (File javaFile : javaFiles) {
                    RandomAccessFile randomAccessResultFile = null;
                    FileReader fileTmpReader = null;
                    String javaFileName = javaFile.getAbsolutePath();
                    try {
                        if (!isPackageWordExistsInFile(javaFile)) {
                            javaFile.renameTo(new File(javaFileName + "_tmp"));
                            File resultFile = new File(javaFileName);
                            boolean isResultFileCreated = resultFile.createNewFile();
                            randomAccessResultFile = new RandomAccessFile(resultFile, "rw");
                            String packageToWrite = PACKAGE_WORD + packageName + ";" + "\n";
                            System.out.println("ResultFile: " + resultFile.getAbsolutePath() + " string to write: "
                                    + packageToWrite + " created: " + isResultFileCreated);
                            randomAccessResultFile.write(packageToWrite.getBytes());
                            copyContentFile(javaFileName + "_tmp", resultFile.getAbsolutePath());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        new File(javaFileName + "_tmp").delete();
                        try {
                            if (randomAccessResultFile != null)
                                randomAccessResultFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    /**
     * Check if package word exists
     *
     * @param javaFile file to check
     * @return boolean result if package word exists in file or not
     * @throws IOException
     */
    private static boolean isPackageWordExistsInFile(File javaFile) throws IOException {
        boolean result = false;
        // Open the file that is the first
        // command line parameter
        FileInputStream fstream = null;
        DataInputStream in = null;
        BufferedReader br = null;
        try {
            fstream = new FileInputStream(javaFile);
            // Get the object of DataInputStream
            in = new DataInputStream(fstream);
            br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                //TODO: may be implement this using regular expressions
                //Matcher matcher = PACKAGE_WORD_PATTERN.matcher(strLine);
                if (strLine.startsWith(PACKAGE_WORD)) {
                    System.out.println("!!!!!!!!!!!!!!!!package exists in file: " + javaFile.getAbsolutePath());
                    result = true;
                    break;
                }
            }
        } finally {
            if (fstream != null)
                fstream.close();
            if (in != null)
                in.close();
            if (br != null)
                br.close();
        }

        return result;
    }


    /**
     * Will wrote package keyword with needed value
     */
    private static void writePackageWordToJavaFiles() {

    }

    private static void copyContentFile(String srFile, String dtFile) {

        try {
            File f1 = new File(srFile);
            File f2 = new File(dtFile);
            InputStream in = new FileInputStream(f1);

            //For Append the file.
            OutputStream out = new FileOutputStream(f2, true);
            //For Overwrite the file.
            //OutputStream out = new FileOutputStream(f2);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.println("File copied.");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage() + " in the specified directory.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
