
package com.gqt.core_java.mini_project;

/**
 * @author nayana
 * @category Mini Project
 * Quiz Application with java GUI swing
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiniProject2 {
	static String name;
	static String age;
	static String city;
	static String state;
	static boolean audienceUsed = false;
	static boolean fiftyUsed = false;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Quiz Game");
		frame.setLayout(null);

		JLabel heading = new JLabel("Welcome to Quiz Game!", SwingConstants.CENTER);
		heading.setBounds(0, 5, 400, 40);
		heading.setForeground(Color.orange);
		heading.setFont(new Font("Arial", Font.BOLD, 20));
		frame.add(heading);

		JLabel label = new JLabel("Enter your name:");
		label.setBounds(30, 60, 200, 30);

		JLabel label1 = new JLabel("Enter your age:");
		label1.setBounds(30, 100, 200, 30);

		JLabel label2 = new JLabel("Enter your city:");
		label2.setBounds(30, 140, 200, 30);

		JLabel label3 = new JLabel("Enter your state:");
		label3.setBounds(30, 180, 200, 30);

		JTextField textField = new JTextField();
		textField.setBounds(180, 60, 150, 30);

		JTextField textField1 = new JTextField();
		textField1.setBounds(180, 100, 150, 30);

		JTextField textField2 = new JTextField();
		textField2.setBounds(180, 140, 150, 30);

		JTextField textField3 = new JTextField();
		textField3.setBounds(180, 180, 150, 30);

		JButton button = new JButton("Start Quiz");
		button.setBounds(140, 230, 120, 30);
		button.setBackground(Color.pink);
		button.setForeground(Color.WHITE);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				age = textField1.getText();
				city = textField2.getText();
				state = textField3.getText();

				if (name.isEmpty() || age.isEmpty() || city.isEmpty() || state.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill in all the fields!", "Missing Info",
							JOptionPane.ERROR_MESSAGE);
				} else {
					frame.getContentPane().removeAll();
					frame.repaint();
					showRewardTree(frame, name);
				}
			}
		});

		frame.add(label);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(textField);
		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(button);

		frame.setSize(400, 430);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void showRewardTree(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel heading = new JLabel("Welcome " + name + ", here's the Reward Tree");
		heading.setBounds(60, 10, 300, 30);
		heading.setForeground(Color.BLUE);
		frame.add(heading);

		String[] rewards = { "Q1. ₹ 1,000", "Q2. ₹ 2,000", "Q3. ₹ 5,000", "Q4. ₹ 10,000", "Q5. ₹ 20,000",
				"Q6. ₹ 40,000", "Q7. ₹ 80,000", "Q8. ₹ 2,00,000", "Q9. ₹ 5,00,000", "Q10. ₹ 1,00,00,000" };

		int y = 50;
		for (String reward : rewards) {
			JLabel rewardLabel = new JLabel(reward);
			rewardLabel.setBounds(50, y, 200, 20);
			frame.add(rewardLabel);
			y += 25;
		}

		JButton nextBtn = new JButton("Start Quiz");
		nextBtn.setBounds(120, y + 10, 120, 30);
		frame.add(nextBtn);
		nextBtn.setBackground(Color.PINK);
		nextBtn.setForeground(Color.WHITE);

		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showQuestion1(frame, name);
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion1(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 1st question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);

		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q1.Who developed java?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. Ken Thompson");
		JButton optionB = new JButton("B. Green Team");
		JButton optionC = new JButton("C. Dennis Ritchie");
		JButton optionD = new JButton("D. Martin Richards");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionB) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹1,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion2(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹0", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 10%\nB: 70%\nC: 50%\nD: 10%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionD.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion2(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 2nd question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q2.Which among the following is true about advantages of RAM?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. fast");
		JButton optionB = new JButton("B. slow");
		JButton optionC = new JButton("C. Costly");
		JButton optionD = new JButton("D. Volatile");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionA) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹2,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion3(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹1,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 80%\nB: 50%\nC: 50%\nD: 10%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionB.setVisible(false);
						optionD.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion3(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 3nd question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q3. JVM Full Form _________");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. Java Virtual Machine");
		JButton optionB = new JButton("B. Java Virtual Mechanism");
		JButton optionC = new JButton("C. Java Volatile Machine");
		JButton optionD = new JButton("D. Java Volatile Mechanism");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionA) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹5,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion4(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹2,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 80%\nB: 70%\nC: 50%\nD: 10%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionC.setVisible(false);
						optionD.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion4(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 4th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q4. Which among the following is true?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. int 1a=20;");
		JButton optionB = new JButton("B. int a#b=40;");
		JButton optionC = new JButton("C. Both 1 & 2 are true");
		JButton optionD = new JButton("D. Both 1 & 2 are false");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionD) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹10,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion5(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹5,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 20%\nB: 60%\nC: 10%\nD: 60%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionC.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion5(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 5th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q5. In which year was Java developed?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. 1962");
		JButton optionB = new JButton("B. 1965");
		JButton optionC = new JButton("C. 1995");
		JButton optionD = new JButton("D. 1996");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionC) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹20,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion6(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹10,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 10%\nB: 10%\nC: 80%\nD: 60%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionB.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion6(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 6th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q6. Who is known as the father of the computer?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A.  Alan Turing");
		JButton optionB = new JButton("B. Charles Babbage");
		JButton optionC = new JButton("C. Dennis Ritchie");
		JButton optionD = new JButton("D. Martin Richards");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionB) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹40,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion7(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹20,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 10%\nB: 30%\nC: 30%\nD: 20%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionD.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion7(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 7th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q7. Who developed the C Programming Language?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. Bjarne Stroustrup");
		JButton optionB = new JButton("B. Charles Babbage");
		JButton optionC = new JButton("C. James Gosling");
		JButton optionD = new JButton("D. Dennis Ritchie");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionD) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹80,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion8(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹40,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 40%\nB: 30%\nC: 30%\nD: 50%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionC.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion8(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 8th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q8. Remove duplicates in SQL?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. REMOVE");
		JButton optionB = new JButton("B. DISTINCT");
		JButton optionC = new JButton("C. UNIQUE");
		JButton optionD = new JButton("D. DELETE");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionB) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹2,00,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion9(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹80,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 40%\nB: 75%\nC: 30%\nD: 70%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionC.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion9(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 9th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q9. What is the full form of CPU?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. Central Process Unit");
		JButton optionB = new JButton("B. Central Processing Unit");
		JButton optionC = new JButton("C. Control Processing Unit");
		JButton optionD = new JButton("D. Central Primary Unit");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionB) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹5,00,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showQuestion10(frame, name);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹2,00,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 10%\nB: 30%\nC: 30%\nD: 20%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionC.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showQuestion10(JFrame frame, String name) {
		frame.getContentPane().removeAll();
		frame.repaint();

		JLabel questionLabel = new JLabel(name + ", here is your 10th question:");
		questionLabel.setBounds(30, 30, 400, 30);
		frame.add(questionLabel);
		questionLabel.setForeground(Color.ORANGE);

		JLabel questionText = new JLabel("Q10.  Use of GROUP BY?");
		questionText.setBounds(30, 60, 300, 30);
		frame.add(questionText);
		questionText.setForeground(Color.MAGENTA);

		JButton optionA = new JButton("A. Sort");
		JButton optionB = new JButton("B. Filter");
		JButton optionC = new JButton("C. Group same rows");
		JButton optionD = new JButton("D. Delete");
		JButton lifeline = new JButton("Lifeline (5)");

		optionA.setBounds(30, 100, 150, 30);
		optionB.setBounds(200, 100, 150, 30);
		optionC.setBounds(30, 140, 150, 30);
		optionD.setBounds(200, 140, 150, 30);
		lifeline.setBounds(110, 190, 150, 30);

		frame.add(optionA);
		frame.add(optionB);
		frame.add(optionC);
		frame.add(optionD);
		frame.add(lifeline);

		ActionListener answerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton clicked = (JButton) e.getSource();
				if (clicked == optionC) {
					JOptionPane.showMessageDialog(frame, name + ", Correct Answer! You won ₹1,00,00,000", "Correct",
							JOptionPane.INFORMATION_MESSAGE);
					showDetails(frame);
				} else {
					JOptionPane.showMessageDialog(frame, name + ", Wrong Answer! You won ₹5,00,000", "Wrong",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		};

		optionA.addActionListener(answerListener);
		optionB.addActionListener(answerListener);
		optionC.addActionListener(answerListener);
		optionD.addActionListener(answerListener);

		lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!audienceUsed || !fiftyUsed) {
					String[] options = { "Audience Poll", "50-50" };
					int choice = JOptionPane.showOptionDialog(frame, "Choose a lifeline:", "Lifeline",
							JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

					if (choice == 0 && !audienceUsed) {
						audienceUsed = true;
						JOptionPane.showMessageDialog(frame, "Audience Poll:\nA: 40%\nB: 30%\nC: 90%\nD: 50%",
								"Audience Poll", JOptionPane.INFORMATION_MESSAGE);
					} else if (choice == 1 && !fiftyUsed) {
						fiftyUsed = true;
						optionA.setVisible(false);
						optionB.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(frame, "You have already used this lifeline!", "Used",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "All lifelines already used!", "No Lifelines Left",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		frame.revalidate();
		frame.repaint();
	}

	public static void showDetails(JFrame frame) {
		String message = "Congratulations " + name + "!\n\n" + "You have successfully completed the quiz.\n"
				+ "You won: ₹1,00,00,000\n\n" + "Your Details:\n" + "Name: " + name + "\n" + "Age: " + age + "\n"
				+ "City: " + city + "\n" + "State: " + state;

		JOptionPane.showMessageDialog(frame, message, "Quiz Completed", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

}
