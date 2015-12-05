package calculatrice;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class calculatrice {

	private JFrame frame;
	private JFrame frame2;
	private JTextField textField;
	private JTextField textField2;

	private String result_string_deux = "";
	private String result_string = "";
	private boolean virgule = false;
	private String operator = "";
	private String save_deux = "";
	private String save_operator = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculatrice window = new calculatrice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	private String doOperation(String operator, double result_un,
			double result_deux) {
		if (operator == "+") {
			return (new Double(result_un + result_deux).toString());
		} else if (operator == "-") {
			return (new Double(result_un - result_deux).toString());
		} else if (operator == "*") {
			return (new Double(result_un * result_deux).toString());
		} else if (operator == "/") {
			return (new Double(result_un / result_deux).toString());
		} else if (operator == "%") {
			return (new Double(result_un % result_deux).toString());
		}
		return "0";
	}

	public calculatrice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 262, 286);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		frame.setResizable(false);
		textField = new JTextField();
		textField.setEditable(false);

		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(textField, "2, 4, 9, 1, fill, default");
		textField.setColumns(10);
		textField.setText("");

		JButton btnRet = new JButton("ret");
		btnRet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textField.getText().isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (ret.indexOf("+") == -1 && ret.indexOf("-") == -1
							&& ret.indexOf("*") == -1 && ret.indexOf("/") == -1
							&& ret.indexOf("%") == -1) {
						textField.setText(textField.getText().substring(0,
								textField.getText().length() - 1));
					}
				}
			}
		});
		frame.getContentPane().add(btnRet, "4, 6, 3, 1");

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				virgule = false;
				result_string_deux = "";
				operator = "";
			}
		});
		frame.getContentPane().add(btnC, "8, 6");

		JButton button_15 = new JButton("%");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == "") {
					result_string = textField.getText();
				} else if (!result_string.isEmpty()
						&& !textField
								.getText()
								.substring(result_string.length() + 1,
										textField.getText().length()).isEmpty()) {
					result_string_deux = textField.getText().substring(
							result_string.length() + 1,
							textField.getText().length());
					textField.setText(doOperation(operator,
							Double.parseDouble(result_string),
							Double.parseDouble(result_string_deux)));
					result_string = textField.getText();
					result_string_deux = "";
				}
				if (!result_string.isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (ret.indexOf("+") == -1 && ret.indexOf("-") == -1
							&& ret.indexOf("*") == -1 && ret.indexOf("/") == -1
							&& ret.indexOf("%") == -1) {
						textField.setText(textField.getText() + "%");
						operator = "%";
						virgule = false;
					}
				}
			}
		});
		frame.getContentPane().add(button_15, "10, 6");

		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "7");
			}
		});
		frame.getContentPane().add(button_7, "4, 8");

		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "8");
			}
		});
		frame.getContentPane().add(button_8, "6, 8");

		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "9");
			}
		});
		frame.getContentPane().add(button_9, "8, 8");

		JButton button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == "") {
					result_string = textField.getText();
				} else if (!result_string.isEmpty()
						&& !textField
								.getText()
								.substring(result_string.length() + 1,
										textField.getText().length()).isEmpty()) {
					result_string_deux = textField.getText().substring(
							result_string.length() + 1,
							textField.getText().length());
					textField.setText(doOperation(operator,
							Double.parseDouble(result_string),
							Double.parseDouble(result_string_deux)));
					result_string = textField.getText();
					result_string_deux = "";
				}
				if (!result_string.isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (ret.indexOf("+") == -1 && ret.indexOf("-") == -1
							&& ret.indexOf("*") == -1 && ret.indexOf("/") == -1
							&& ret.indexOf("%") == -1) {
						textField.setText(textField.getText() + "/");
						operator = "/";
						virgule = false;
					}
				}
			}
		});
		frame.getContentPane().add(button_14, "10, 8");

		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "4");
			}
		});
		frame.getContentPane().add(button_4, "4, 10");

		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "5");
			}
		});
		frame.getContentPane().add(button_5, "6, 10");

		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "6");
			}
		});
		frame.getContentPane().add(button_6, "8, 10");

		JButton button_13 = new JButton("*");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == "") {
					result_string = textField.getText();
				} else if (!result_string.isEmpty()
						&& !textField
								.getText()
								.substring(result_string.length() + 1,
										textField.getText().length()).isEmpty()) {
					result_string_deux = textField.getText().substring(
							result_string.length() + 1,
							textField.getText().length());
					textField.setText(doOperation(operator,
							Double.parseDouble(result_string),
							Double.parseDouble(result_string_deux)));
					result_string = textField.getText();
					result_string_deux = "";
				}
				if (!result_string.isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (ret.indexOf("+") == -1 && ret.indexOf("-") == -1
							&& ret.indexOf("*") == -1 && ret.indexOf("/") == -1
							&& ret.indexOf("%") == -1) {
						textField.setText(textField.getText() + "*");
						operator = "*";
						virgule = false;
					}
				}
			}
		});
		frame.getContentPane().add(button_13, "10, 10");

		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "1");
			}
		});
		frame.getContentPane().add(button, "4, 12");

		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(textField.getText() + "2");
			}
		});
		frame.getContentPane().add(button_1, "6, 12");

		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "3");
			}
		});
		frame.getContentPane().add(button_3, "8, 12");

		JButton button_12 = new JButton("-");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operator == "") {
					result_string = textField.getText();
				} else if (!result_string.isEmpty()
						&& !textField
								.getText()
								.substring(result_string.length() + 1,
										textField.getText().length()).isEmpty()) {
					result_string_deux = textField.getText().substring(
							result_string.length() + 1,
							textField.getText().length());
					textField.setText(doOperation(operator,
							Double.parseDouble(result_string),
							Double.parseDouble(result_string_deux)));
					result_string = textField.getText();
					result_string_deux = "";
				}
				if (!result_string.isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (ret.indexOf("+") == -1 && ret.indexOf("-") == -1
							&& ret.indexOf("*") == -1 && ret.indexOf("/") == -1
							&& ret.indexOf("%") == -1) {
						textField.setText(textField.getText() + "-");
						operator = "-";
						virgule = false;
					}
				}
			}
		});
		frame.getContentPane().add(button_12, "10, 12");

		JButton button_2 = new JButton("0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(textField.getText() + "0");
			}
		});
		frame.getContentPane().add(button_2, "4, 14");

		JButton button_11 = new JButton("+");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (operator == "") {
					result_string = textField.getText();
				} else if (!result_string.isEmpty()
						&& !textField
								.getText()
								.substring(result_string.length() + 1,
										textField.getText().length()).isEmpty()) {
					result_string_deux = textField.getText().substring(
							result_string.length() + 1,
							textField.getText().length());
					textField.setText(doOperation(operator,
							Double.parseDouble(result_string),
							Double.parseDouble(result_string_deux)));
					result_string = textField.getText();
					result_string_deux = "";
				}

				if (!result_string.isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (ret.indexOf("+") == -1 && ret.indexOf("-") == -1
							&& ret.indexOf("*") == -1 && ret.indexOf("/") == -1
							&& ret.indexOf("%") == -1) {
						textField.setText(textField.getText() + "+");
						operator = "+";
						virgule = false;
					}
				}
			}
		});

		JButton button_10 = new JButton(",");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					String ret = textField.getText().substring(
							textField.getText().length() - 1,
							textField.getText().length());
					if (virgule == false && ret.indexOf("+") == -1
							&& ret.indexOf("-") == -1 && ret.indexOf("*") == -1
							&& ret.indexOf("/") == -1 && ret.indexOf("%") == -1) {
						textField.setText(textField.getText() + ".");
						virgule = true;
					}
				}
			}
		});
		frame.getContentPane().add(button_10, "6, 14");

		JButton button_16 = new JButton("=");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!result_string.isEmpty()
						&& textField.getText().length() > (result_string
								.length() + 1)) {
					result_string_deux = textField.getText().substring(
							result_string.length() + 1,
							textField.getText().length());
					textField.setText(doOperation(operator,
							Double.parseDouble(result_string),
							Double.parseDouble(result_string_deux)));
					result_string = textField.getText();
					save_operator = operator;
					save_deux = result_string_deux;
					result_string_deux = "";
					operator = "";
					virgule = false;
				} else if (!result_string.isEmpty() && !save_deux.isEmpty()) {
					textField.setText(doOperation(save_operator,
							Double.parseDouble(result_string),
							Double.parseDouble(save_deux)));
					result_string = textField.getText();
					result_string_deux = "";
					operator = "";
				}
			}
		});

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println(e.getKeyChar());
				switch (e.getKeyChar()) {
				case '0':
					button_2.doClick();
					break;
				case '1':
					button.doClick();
					break;
				case '2':
					button_1.doClick();
					break;
				case '3':
					button_3.doClick();
					break;
				case '4':
					button_4.doClick();
					break;
				case '5':
					button_5.doClick();
					break;
				case '6':
					button_6.doClick();
					break;
				case '7':
					button_7.doClick();
					break;
				case '8':
					button_8.doClick();
					break;
				case '9':
					button_9.doClick();
					break;
				case '\n':
					button_16.doClick();
					break;
				case '.':
					button_10.doClick();
					break;
				case '+':
					button_11.doClick();
					break;
				case '-':
					button_12.doClick();
					break;
				case '*':
					button_13.doClick();
					break;
				case '/':
					button_14.doClick();
					break;
				case '%':
					button_15.doClick();
					break;
				default:
					// System.out.println(e.getKeyCode());
					if (e.getKeyCode() == 8)
						btnRet.doClick();
					break;
				}
			}
		});
		frame.getContentPane().add(button_16, "8, 14");
		frame.getContentPane().add(button_11, "10, 14");

		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator, "4, 16, 7, 2");

		JButton btnNewButton = new JButton("Cos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && operator == "") {
					textField.setText(String.valueOf(Math.cos(Double
							.parseDouble(textField.getText()))));
				}
			}
		});
		frame.getContentPane().add(btnNewButton, "4, 18");

		JButton btnSin = new JButton("Sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && operator == "") {
					textField.setText(String.valueOf(Math.sin(Double
							.parseDouble(textField.getText()))));
				}
			}
		});
		frame.getContentPane().add(btnSin, "6, 18");
		
				JButton btnNewButton_1 = new JButton(" \u221A");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!textField.getText().isEmpty() && operator == "") {
							textField.setText(String.valueOf(Math.sqrt(Double
									.parseDouble(textField.getText()))));
						}
					}
				});
				
				JButton btnTan = new JButton("Tan");
				btnTan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!textField.getText().isEmpty() && operator == "") {
							textField.setText(String.valueOf(Math.tan(Double
									.parseDouble(textField.getText()))));
						}
					}
				});
				frame.getContentPane().add(btnTan, "8, 18");
				frame.getContentPane().add(btnNewButton_1, "10, 18");
	}

}