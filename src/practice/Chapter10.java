package practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter10 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		List<Task> list = new ArrayList<>();
        list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
        list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
        list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
        list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
        list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

        long count = list.stream().filter(p -> p.isDone() ==false).count();
        System.out.println("未完了のタスクの個数は" + count);
        System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");
        
        list.stream() // Streamを生成
        .sorted(Comparator.comparing(Task::getDate))
        .filter(f -> f.isDone() != true)
		.map(f -> f.toString())
	    .collect(Collectors.toList())
	    .forEach(System.out::println);
        
	}

}
