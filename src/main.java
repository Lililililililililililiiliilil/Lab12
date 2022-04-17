import java.util.*;
import java.util.stream.*;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer> temp_diary = new ArrayList<Integer>();
        Collections.addAll(temp_diary, -2, -5, -2, -4, 3, -6, -2,
                -1, 5, 1, 1, 0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11);

        long below_zero_days = temp_diary.stream().filter(x -> x < 0).count();
        System.out.println(below_zero_days);

        if (temp_diary.stream().anyMatch(x -> x > 10)) {
            System.out.println("Есть дни с температурой больше десяти");
        } else {
            System.out.println("Таковые дни отсутствуют");
        }

        Optional<Integer> max_first_week = temp_diary.subList(0, 7).stream().max(Integer::compareTo);

        System.out.println(max_first_week.get());

        OptionalDouble avg = temp_diary.stream().mapToDouble(x -> x).average();

        System.out.printf("Средняя температура за март: %.2f", avg.getAsDouble());

        System.out.println();

        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();

        String[] sen_list = sentence.split("[\\s,]+");
        List<String> sents = Arrays.asList(sen_list);
        long es_counter = sents.stream().filter(x -> x.endsWith("es")).count();

        System.out.println(es_counter);

        Comparator<String> compare = (firstStr, secondStr) -> Integer.compare(firstStr.length(), secondStr.length());

        sents.sort(compare);
        System.out.println(sents);
    }
}

