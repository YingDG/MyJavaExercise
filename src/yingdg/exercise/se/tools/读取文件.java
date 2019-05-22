package yingdg.exercise.se.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author YingDG
 * created in 2019/5/22 11:11 AM
 */
public class 读取文件 {
    public static void main(String[] args) {
        Path path = Paths.get("./src/yingdg/exercise/se/package-info.java");
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional.ofNullable(lines).ifPresent(e -> e.forEach(System.out::println));
    }
}
