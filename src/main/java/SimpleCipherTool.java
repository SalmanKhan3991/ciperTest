public class SimpleCipherTool {

    private int[] keyInt;

    public SimpleCipherTool(String key) {

        keyInt = new int[key.length()];
        char[] keyChar = key.toCharArray();
        for (int i = 0; i < keyChar.length; i++) {
            keyInt[i] = keyChar[i] - 'a' + 1;
        }

    }

    public String cipher(String text) {
        char[] textArray = text.toCharArray();
        StringBuilder str = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < textArray.length) {
            char r = (char) ((textArray[i] + keyInt[j]));
            if (r > 'z') {
                r = (char) (r - 26);
            }

            if (textArray[i] >= 'a' && textArray[i] <= 'z') {
                str.append(String.valueOf(r));
            } else {
                str.append(textArray[i]);
            }
            i++;
            j = (j + 1) % keyInt.length;
        }

        return str.toString();
    }

    public String decipher(String cipheredText) {
        char[] textArray = cipheredText.toCharArray();
        StringBuilder str = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < textArray.length) {
            char r = (char) ((textArray[i] - keyInt[j]));

            if (r < 'a') {
                r = (char) (r + 26);
            }

            if (textArray[i] >= 'a' && textArray[i] <= 'z') {
                str.append(String.valueOf(r));
            } else {
                str.append(textArray[i]);
            }
            i++;
            j = (j + 1) % keyInt.length;

        }

        return str.toString();
    }

    public static void main(String[] args) {

        SimpleCipherTool tool = new SimpleCipherTool("arvoia");

        System.out.println(tool.decipher("ilpeb://cxcivt.rxn/uodacbrkar/tsieufusozmt"));
        System.out.println(tool.cipher("https://github.com/csorbazoli/sampletaskds"));

        SimpleCipherTool newTool = new SimpleCipherTool("abc");
        System.out.println(newTool.cipher("Sample task."));
        System.out.println(newTool.decipher("Scpqnh vdtm."));
    }
}
