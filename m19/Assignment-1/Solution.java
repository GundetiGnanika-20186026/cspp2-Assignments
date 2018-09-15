import java.util.Scanner;
import java.util.Arrays;
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				startQuiz(s, q, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				displayScore(q);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		boolean tockenssize = true;
		if (questionCount == 0) {
			System.out.println("Quiz does not have questions");
		} else  {
			for (int i = 0; i < questionCount; i++) {
				String[] tockens = s.nextLine().split(":");

				if (tockens.length != 5) {
					System.out.println("Error! Malformed question");

				} else if ((Integer.parseInt(tockens[3]) < 0)) {
					System.out.println("Invalid max marks for " + tockens[0]);
				} else if ((Integer.parseInt(tockens[4]) > 0)) {
					System.out.println("Invalid penalty for " + tockens[0]);

				} else if((Integer.parseInt(tockens[2]) > 4 )){
					System.out.println("Error! Correct answer choice number is out of range for"+ tockens[0]);
				}
				else {
					quiz.questionsarray[i] = tockens[0] + "(" + tockens[3] + ")";
					quiz.choicesarray[i] = (Arrays.toString((tockens[1]).split(",")));
					quiz.length = quiz.length + 1;
					quiz.size = quiz.size + 1;


				}
			}
			//  if(tockenssize){
			//    System.out.println(questionCount+" are added to the quiz");
			// }
		}

	}


	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		// if(quiz.length <= 2) {
		// 	System.out.println("");
		// }
		// quiz.rightanswer = answerCount;
		// for(int i = 0; i < quiz.size ;i++) {
		// 	System.out.println(quiz.questionsarray[i]);

		// 	quiz.choicesarray[i].replace("[","").replace("]","");
		// 	String[] newchoice =(quiz.choicesarray[i].split(","));
		// 	for(int j = 0 ; j < quiz.length-1; j++){
		// 	 	System.out.print(newchoice[j]+ "	");
		//     }

		// 	 System.out.println(newchoice[quiz.length-1]);
		// }

	}

	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {

	}
}
class Quiz {
	public String[] questionsarray;
	public String[] choicesarray;
	int size;
	int rightanswer;
	int length;
	Quiz() {
		questionsarray = new String[50];
		choicesarray = new String[500];
		length = 0;
		size = 0;
	}




}
