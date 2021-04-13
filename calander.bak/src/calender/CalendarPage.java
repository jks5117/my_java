package calender;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CalendarPage extends JFrame {
	// 해당하는 달을 배열에 담자.
	String[] months = { "January", "Febrary", "March", "April", "May", "June", "July", "August", "September", "Octber",
			"November", "December" };

	public final static int dom[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 카렌다의 어느곳에 어느날을 넣을것인지를 계산한다.
	public void print(int mm, int yy) {




		int leadGap = 0;
		System.out.print(months[mm]);
		System.out.print(" ");
		System.out.print(yy);
		System.out.println();
	
		String cols[] = { "Su", "Mo", "Tu", "We", "Th", "Fr", "Sa" };
		String data[][] = new String[7][7];
		DefaultTableModel dtm = new DefaultTableModel(data, cols);
		JTable jtb = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jtb);
		this.add("Center", jsp);
		this.setSize(800, 600);
		this.setVisible(true);
		GregorianCalendar calendar = new GregorianCalendar(yy, mm, 1);
		System.out.println("Su Mo Tu We Th Fr Sa");
		leadGap = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int dayInMonth = dom[mm];
		// 윤달일 경우.
		if (calendar.isLeapYear(calendar.get(Calendar.YEAR)) && mm == 1)
			++dayInMonth;
		// 해당하는 달의 첫째날 이전을 비워준다.
		for (int i = 0; i < leadGap; i++) {
			System.out.print("   ");
		}
		// 그 달을 해당하는 날 수로 채운다.
		for (int i = 1; i <= dayInMonth; i++) {
			if (i < 10)
				System.out.print(" ");
			System.out.print(i);
			if ((leadGap + i) % 7 == 0)
				System.out.println();
			else
				System.out.print(" ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		CalendarPage cp = new CalendarPage();
		Calendar c = Calendar.getInstance();

		cp.print(c.get(Calendar.MONTH) - 1, c.get(Calendar.YEAR)-1);
		System.out.println();
		cp.print(c.get(Calendar.MONTH), c.get(Calendar.YEAR));
		System.out.println();
		cp.print(c.get(Calendar.MONTH) + 1, c.get(Calendar.YEAR));
	}
}