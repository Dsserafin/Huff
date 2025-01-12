import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public Main() throws IOException {
    }

    public static void main (String[]args) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/main/java/test.txt")));
        ArrayList<Node> characters = new ArrayList<>();
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
        char c = 'x';
        for (int i = 0; i < nodes.length; i++){
            Node temp = new Node(characters.get(i).getLeft(), characters.get(i).getRight(), characters.get(i).getCharacter());
            temp.setFrequency(characters.get(i).getFrequency());
            nodes[i] = temp;
        }
        Huffman huff = new Huffman(nodes);
        Node fin = huff.HuffmanAlgorithm();
        System.out.println(nodes[1].getCharacter());
    }


}
