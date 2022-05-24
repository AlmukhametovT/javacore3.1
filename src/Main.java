import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String gamesLink = "C:\\Users\\TAU\\IdeaProjects\\javacore3.1\\Games\\";
        StringBuilder installReport = new StringBuilder();

        installReport.append(createDir(gamesLink + "src"));
        installReport.append(createDir(gamesLink + "res"));
        installReport.append(createDir(gamesLink + "savegames"));
        installReport.append(createDir(gamesLink + "temp"));
        installReport.append(createDir(gamesLink + "src\\main"));
        installReport.append(createDir(gamesLink + "src\\test"));
        installReport.append(createFile(gamesLink + "src\\main\\Main.java"));
        installReport.append(createFile(gamesLink + "src\\main\\Utils.java"));
        installReport.append(createDir(gamesLink + "res\\drawables"));
        installReport.append(createDir(gamesLink + "res\\vectors"));
        installReport.append(createDir(gamesLink + "res\\icons"));
        installReport.append(createFile(gamesLink + "temp\\temp.txt"));

        try (FileWriter writer = new FileWriter(gamesLink + "temp\\temp.txt", false)) {
            writer.write(String.valueOf(installReport));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String createDir(String dirLink) {
        File dir = new File(dirLink);
        if (dir.mkdir()) {
            return dir.getName() + " - Каталог создан" + "\n";
        } else return dir.getName() + " - Каталог создать не удалось" + "\n";
    }

    public static String createFile(String fileLink) {
        File file = new File(fileLink);
        try {
            if (file.createNewFile())
                return file.getName() + " - Файл создан" + "\n";
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return file.getName() + " - Файл создать не удалось" + "\n";
    }
}