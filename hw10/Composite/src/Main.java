public class Main {
    public static void main(String[] args) {
        File file1 = new File("File1.txt", 10.8f);
        File file2 = new File("File2.txt", 21.7f);
        File file3 = new File("File3.txt", 43.1f);
        File file4 = new File("File4.txt", 53.5f);

        Directory root = new Directory("Root");
        Directory subDir1 = new Directory("SubDirectory1");
        Directory subDir2 = new Directory("SubDirectory2");

        root.Add(file1);
        root.Add(file2);
        root.Add(subDir1);
        subDir1.Add(file3);
        subDir1.Add(subDir2);
        subDir2.Add(file4);

        root.Display(0);
        System.out.println(STR."\nTotal size of '\{root.name}' directory: \{root.GetSize()} KB");

        subDir2.Remove(file1);
        root.Remove(subDir1);
        root.Display(0);
    }
}
