import java.util.Random;

class ShuffleString {

    private final String word;

    public ShuffleString(String original_word){
        word = original_word;
    }

    public String getWord() {
        Random rand = new Random();

        // splitting the word into letters and appending to array.
        char[] original_arr = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            original_arr[i] = word.charAt(i);
        }

        char[] shuffled_arr = new char[word.length()];
        int[] rand_arr = new int[word.length()];

        int rand_num = rand.nextInt(word.length());
        rand_arr[0] = rand_num;
        shuffled_arr[0] = original_arr[rand_num];

        int j = 1;
        while(j < original_arr.length){
            boolean flag;
            do{
                flag = false;
                rand_num = rand.nextInt(original_arr.length);
                for (int x = 0; x < j; x++){
                    if (rand_arr[x] == rand_num){
                        flag = true;
                        break;
                    }
                }
            } while (flag);

            if(!flag){
                rand_arr[j] = rand_num;
                shuffled_arr[j] = original_arr[rand_num];
                j++;
            }
        }
        return new String(shuffled_arr);
    }

}