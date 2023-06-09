import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncoding {

    private static final Map<Character, String> characterToCode = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj tekst do zakodowania: ");
        String inputText = scanner.nextLine().replaceAll("[^a-zA-Z]", "");

        Map<Character, Integer> characterFrequency = countCharacterFrequency(inputText);
        PriorityQueue<HuffmanNode> minHeap = buildMinHeap(characterFrequency);

        HuffmanNode root = buildHuffmanTree(minHeap);
        generateCharacterCodes(root, "");

        System.out.println("Kodowanie Huffmana:");
        for (Map.Entry<Character, String> entry : characterToCode.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static Map<Character, Integer> countCharacterFrequency(String text) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for (char c : text.toCharArray()) {
            characterFrequency.put(c, characterFrequency.getOrDefault(c, 0) + 1);
        }
        return characterFrequency;
    }

    private static PriorityQueue<HuffmanNode> buildMinHeap(Map<Character, Integer> characterFrequency) {
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : characterFrequency.entrySet()) {
            minHeap.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return minHeap;
    }

    private static HuffmanNode buildHuffmanTree(PriorityQueue<HuffmanNode> minHeap) {
        while (minHeap.size() > 1) {
            HuffmanNode left = minHeap.poll();
            HuffmanNode right = minHeap.poll();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            minHeap.offer(parent);
        }
        return minHeap.poll();
    }

    private static void generateCharacterCodes(HuffmanNode root, String code) {
        if (root.isLeaf()) {
            characterToCode.put(root.character, code);
            return;
        }

        generateCharacterCodes(root.left, code + "0");
        generateCharacterCodes(root.right, code + "1");
    }
}
