package com.company.nio.watcher;

import java.io.IOException;
import java.nio.file.*;

public class Watcher {
    public static void main(String[] args) throws IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path directory = Paths.get("C:\\Users\\Administrator\\Desktop\\share\\");
        WatchKey watchKey = directory.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.OVERFLOW
        );
        while (true){
            for (WatchEvent<?> event : watchKey.pollEvents()){
                System.out.println(event.kind());
                Path file = directory.resolve((Path)event.context());
                System.out.println(file+ " was last modified at "+file.toFile().lastModified());
                System.out.println(file.toFile().getName());
                System.out.println(file.toFile().isFile());
                System.out.println(file.toFile().getAbsolutePath().endsWith("xlsx"));
                System.out.println(file.toFile().canExecute());
                System.out.println(file.endsWith("xlsx"));
                System.out.println(file.toUri());
            }
        }

    }
}
