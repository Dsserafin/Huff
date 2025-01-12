import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public Main() throws IOException {
    }

    public static void main (String[]args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/main/java/test.txt")));
        List<Node> characters = new ArrayList<>();
        for (int i = 0; i < content.length(); i++){
            char c = content.charAt(i);
            boolean check_for_match = false;
            for (int j = 0; j < characters.size(); j++ ){
                if (characters.get(j).getCharacter() == c){
                    characters.get(j).setFrequency(characters.get(j).getFrequency() + 1);
                    check_for_match = true;
                    break;
                }
            }
            if (!check_for_match){
                characters.add(new Node(null, null, c));
                characters.get(characters.size()-1).setFrequency(characters.get(characters.size()-1).getFrequency() + 1);
            }
        }
        Node[] nodes = new Node[characters.size()];
        int index = 0;
        for (int i = 0; i < content.length(); i++){
            char c = content.charAt(i);
            boolean check_for_match = false;
            for (int j = 0; j < index; j++ ){
                if (nodes[j].getCharacter() == c){
                    nodes[j].setFrequency(nodes[j].getFrequency() + 1);
                    check_for_match = true;
                    break;
                }
            }
            if (!check_for_match){
                nodes[index] = (new Node(null, null, c));
                nodes[index].setFrequency(nodes[index].getFrequency() + 1);
                index++;
            }
        }
        Huffman huff = new Huffman(nodes);
        huff.setCompressing();
        ObjectOutputStream outputStream = null;
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            for (int j = 0; j < huff.getCompressed().size(); j++){
                if (huff.getCompressed().get(j).getCharacter() == c){
                    try {
                        outputStream = new ObjectOutputStream(new FileOutputStream("src/main/java/path.out"));
                        outputStream.writeObject(huff.getCompressed().get(j).getHuffmanCodeBit());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }


    }
}
