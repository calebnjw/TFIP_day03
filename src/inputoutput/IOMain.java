package inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOMain {
  public static void main(String[] args) throws IOException {
    for (String string : args) {
      System.out.println(string);
    }

    // get reference to file
    Path p = Paths.get(args[0]);

    // get actual file
    File f = p.toFile();

    System.out.printf("Exists? %b \n", f.exists());
    System.out.printf("Is file? %b \n", f.isFile());
    System.out.printf("Is directory? %b \n", f.isDirectory());
    System.out.printf("Is readable? %b \n", f.canRead());
    System.out.printf("Is hidden? %b \n", f.isHidden());
    System.out.printf("File size? %d \n", f.length());
    System.out.printf("Full path? %s \n", f.getAbsolutePath());

    // opening file
    InputStream is = new FileInputStream(f);
    // output stream will create a copy of the file
    OutputStream os = new FileOutputStream("Copy of %s".formatted(args[0]));
    byte[] buffer = new byte[1024];
    int size = 0;

    // while (size > 0) {
    //   size = is.read(buffer);
    //   System.out.printf("size: %d", size);
    //   if (size > 0) {
    //     os.write(buffer, 0, size);
    //   }
    // }

    while ((size = is.read(buffer)) > 0) {
      os.write(buffer, 0, size);
    }

    // flush buffer
    os.flush();
    
    // close files
    os.close();
    is.close();
  }


  // std in -> stdout
  //        -> stderr
}