package Code;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ImageProcessor {

    private static boolean continueRequest = false;

    private File currentFile;
    private File[] toProcess;
    private File[] processed;


    //
    public File[] getEveryFile(File folder) {

        List<File> fileList = new ArrayList<File>();

        Collections.addAll(fileList, Objects.requireNonNull(folder.listFiles()));

        return fileList.toArray(new File[fileList.size()]);
    }




    //
    public void changeWindow(baseWindow window) {
        window.getFormattedTextField1().setText("Check");
    }


    public static boolean isContinueRequest() {return continueRequest;}
    public static void setContinueRequest(boolean continueRequest) {ImageProcessor.continueRequest = continueRequest;}

    public File getCurrentFile() {return currentFile;}
    public void setCurrentFile(File currentFile) {this.currentFile = currentFile;}

    public File[] getToProcess() {return toProcess;}
    public void setToProcess(File[] toProcess) {this.toProcess = toProcess;}

    public File[] getProcessed() {return processed;}
    public void setProcessed(File[] processed) {this.processed = processed;}
}
