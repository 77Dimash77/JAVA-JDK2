package DZ4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String fileUrl = "https://example.com/file.zip";
        String destinationPath = "downloaded_file.zip";
        int numThreads = 3;

        downloadFile(fileUrl, destinationPath, numThreads);
    }

    public static void downloadFile(String fileUrl, String destinationPath, int numThreads) {
        try {
            URL url = new URL(fileUrl);
            InputStream inputStream = url.openStream();
            FileOutputStream outputStream = new FileOutputStream(destinationPath);

            ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                final int currentBytesRead = bytesRead;
                executorService.execute(() -> {
                    try {
                        outputStream.write(buffer, 0, currentBytesRead);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            executorService.shutdown();
            while (!executorService.isTerminated()) {

            }

            inputStream.close();
            outputStream.close();

            System.out.println("Файл успешно скачан.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
