package mmtr.klyuev.dictionary;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryStorageOnFileSystem implements DictionaryStorage {
	private File dict1 = new File("Dict1.txt");
    private File dict2 = new File("Dict2.txt");
    private Scanner scanner;
    private HashMap<String, String> map = new HashMap<>();
	
	    public void createMap(File file) {
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String args[] = line.split(" ");
                map.put(args[0], args[1]);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
			scanner.close();
		}
    }

    public String getTranslateWord(String key) {
        return map.get(key);
    }


    @Override
    public String showAllWords() {
        String str = "";
        try {
            scanner = new Scanner(dict1);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                str = str + line + "\n";
                if (!scanner.hasNextLine()) str = str + line;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
			scanner.close();
		}
        return str;
    }

    @Override
    public String translateOneWord(String str) {
        createMap(dict1);
        return getTranslateWord(str);
    }

    @Override
    public void addWord(String str) {
        try (FileWriter writer = new FileWriter(dict1, true)) {
			writer.write(str + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean  deleteWord(String str) {
        File temp = new File("Temp.txt");
        String s;
        boolean deleteResult = false;
        try {
            scanner = new Scanner(dict1);
            try (PrintWriter tempWriter = new PrintWriter(new FileWriter(temp))) {
                while(scanner.hasNextLine()) {
                    s = scanner.nextLine();
                    if (!s.trim().contains(str)) {
                        tempWriter.println(s);
                        tempWriter.flush();
                        deleteResult = !s.contains(str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
			scanner.close();
		}
        dict1.delete();
        temp.renameTo(dict1);
        return deleteResult;
    }
}