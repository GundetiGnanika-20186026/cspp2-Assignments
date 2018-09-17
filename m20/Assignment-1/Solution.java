import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
	/**
	 * { var_description }.
	 */
	private String questiontext;
	/**
	 * { var_description }.
	 */
	private String[] choices;
	/**
	 * { var_description }.
	 */
	private int correctAnswer;
	/**
	 * { var_description }.
	 */
	private int maxMarks;
	/**
	 * { var_description }.
	 */
	private int penalty;
	/**
	 * { var_description }.
	 */
	private String response;
	/**
	 * Constructs the object.
	 */
	Question() {
		choices = new String[50];

	}
	/**
	 * Constructs the object.
	 *
	 * @param      question1       The question 1
	 * @param      choices1        The choices 1
	 * @param      correctAnswer1  The correct answer 1
	 * @param      maxMarks1       The maximum marks 1
	 * @param      penalty1        The penalty 1
	 */
	Question(final String question1, final String[] choices1,
	         final int correctAnswer1, final int maxMarks1, final int penalty1) {
		this.questiontext = question1;
		this.choices = choices1;
		this.correctAnswer = correctAnswer1;
		this.maxMarks = maxMarks1;
		this.penalty = penalty1;

	}
	/**
	 * { function_description }.
	 *
	 * @param      choice  The choice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean evaluateResponse(final String choice) {
		if (Integer.parseInt(choice) == correctAnswer) {
			return true;
		}
		return false;
	}
	/**
	 * Gets the correct answer.
	 *
	 * @return     The correct answer.
	 */
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	/**
	 * Gets the question text.
	 *
	 * @return     The question text.
	 */
	public String getQuestionText() {
		return questiontext;
	}
	/**
	 * Gets the choice.
	 *
	 * @return     The choice.
	 */
	public String[] getChoice() {
		return choices;
	}
	/**
	 * Gets the maximum marks.
	 *
	 * @return     The maximum marks.
	 */
	public int getMaxMarks() {
		return maxMarks;
	}
	/**
	 * Gets the penalty.
	 *
	 * @return     The penalty.
	 */
	public int getPenalty() {
		return penalty;
	}
	/**
	 * Sets the response.
	 *
	 * @param      answer  The answer
	 */
	public void setResponse(final String answer) {
		response = answer;

	}
	/**
	 * Gets the response.
	 *
	 * @return     The response.
	 */
	public String getResponse() {
		return response;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	// public String toString() {
	// 	String s = questiontext + "(" + maxMarks + ")"+'\n';
	// 	for(int i = 0; i < choices.length - 1; i++){
	// 		s = s + choices[i]+ "	";

	// 	}

	// 	return s + choices[choices.length-1];
	// }
}


/**
 * Class for quiz.
 */
class Quiz {
	/**
	 * { var_description }.
	 */
	private final int onehundred = 100;
	/**
	 * { var_description }.
	 */
	private Question[] questions;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	Quiz() {
		questions = new Question[50];
		size = 0;

	}
	/**
	 * Adds a question.
	 *
	 * @param      q     The question
	 */
	//Question queobj = new Question();
	public void addQuestion(final Question q) {
		questions[size++] = q;


	}

	public int getsize(){
		return size;
	}

	/**
	 * Gets the question.
	 *
	 * @param      index  The index
	 *
	 * @return     The question.
	 */
	// public Question getQuestion(final int index) {
	// 	return null;
	// }

	public String toString(int i) {
		String s = "" ;//= queobj.getQuestionText() + "(" + queobj.getMaxMarks() + ")"+'\n';


		s = questions[i].getQuestionText() + "(" + questions[i].getMaxMarks() + ")" + '\n';
		for (int j = 0; j < questions[i].getChoice().length - 1; j++) {
			s = s + questions[i].getChoice()[j] + "	";

		}

		return s + questions[i].getChoice()[questions[i].getChoice().length - 1];
	}

	public Question[] questionarray(){
		return questions;
	}



	/**
	 * Shows the report.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String showReport() {
		String s = "";
		return s;
	}

}
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
	 * @param      scan       The scan
	 * @param      quiz       The quiz
	 * @param      q          The question count
	 *
	 */
	public static void loadQuestions(final Scanner scan,
	                                 final Quiz quiz, final int q) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		boolean res = false;
		boolean continue1 = false;
		if (q <= 0) {
			System.out.println("Quiz does not have questions");
		} else {
			for (int i = 0; i < q; i++) {
				String[] first = scan.nextLine().split(":");
				if (first.length != 5 || first[0].equals("")) {
					System.out.println("Error! Malformed question");
				} else if ((Integer.parseInt(first[3]) < 0)) {
					System.out.println("Invalid max marks for " + first[0]);
				} else if ((Integer.parseInt(first[4]) > 0)) {
					System.out.println("Invalid penalty for " + first[0]);
				} else {
					String[] choicesarr = first[1].split(",");
					if (choicesarr.length < 2) {
						System.out.println(first[0] + " does not have enough answer choices");
					} else if ((Integer.parseInt(first[2]) > 4 )) {
						System.out.println("Error! Correct answer choice number is out of range for " + first[0]);
					} else {
						res = true;
						continue1 = true;
					}

				}
				if (continue1) {
					Question obj = new Question(first[0], first[1].split(","), Integer.parseInt(first[2]), Integer.parseInt(first[3]), Integer.parseInt(first[4]));
					quiz.addQuestion(obj);
				}
			}
			if (res) {
				System.out.println(q + " are added to the quiz");
			}

		}




	}
	/**
	 * Starts a quiz.
	 *
	 * @param      scan  The scan
	 * @param      quiz  The quiz
	 * @param      q     The answer count
	 */
	public static void startQuiz(final Scanner scan,
	                             final Quiz quiz, final int q) {
		// write your code here to display the quiz questions on the console.
		// read the user responses from the console using scanner object.
		// store the user respone in the question object
		String str;
		for (int i = 0; i < quiz.getsize(); i++) {
			//str = quiz.questions[i].getQuestionText()+"("+quiz.questions[i].getMaxMarks() + ")"+'\n';
			// str = str + quiz.questions[i].getChoice()[i]+ "	";
			// System.out.println(str);
			System.out.println(quiz.toString(i));
			System.out.println();
			String ans = scan.nextLine();
			quiz.questionarray()[i].setResponse(ans);




		}




	}
	/**
	 * Displays the score report.
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report using quiz object.
	}
}


