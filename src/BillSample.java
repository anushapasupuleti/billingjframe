import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

import java.util.Date;
import java.util.Random;
import java.util.Timer;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class BillSample extends JFrame {

	private JPanel contentPane;
	private JTextField inv_no;
	private JTextField cus_name;
	private JTextField cus_mob;
	private JTextField tpcode;
	private JTextField tprice;
	private JTextField quantity;
	private JTextField gst;
	private JTextField totalorder;
	private JTable table;
	private JTextField bill_no;
	private JTextField tpname;
	private JTextField prodsearch;
	private JTextField tdis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillSample frame = new BillSample();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   //setjframe
	/**
	 * Create the frame.
	 */
	public BillSample() {
		setBackground(Color.PINK);
		setTitle("                                                                                                        BILLING APP");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BillSample.class.getResource("/image/image/store2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 844);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 813, 113);
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIbotricsBillingQuotation = new JLabel("Mahalaxmi Departmental And General Stores");
		lblIbotricsBillingQuotation.setHorizontalAlignment(SwingConstants.CENTER);
		lblIbotricsBillingQuotation.setBounds(190, 5, 498, 17);
		lblIbotricsBillingQuotation.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblIbotricsBillingQuotation);
		
		JLabel label = new JLabel("");
	label.setBounds(10, 7, 102, 96);
		label.setIcon(new ImageIcon("C:\\Users\\iBotrics\\Desktop\\IBOTRICS IMAGE\\2.png"));
		panel.add(label);
		
		JLabel lblDrNo = new JLabel("Dr.No:18-5-30, Bonda Vari Veedi, palakollu-534260 WG Dist, AP.");
		lblDrNo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDrNo.setBounds(226, 33, 350, 32);
		panel.add(lblDrNo);
		
		JLabel lblGstIn = new JLabel("    GST IN:37BIVPN5224M");
		lblGstIn.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGstIn.setBounds(134, 61, 169, 40);
		panel.add(lblGstIn);
		
		JLabel lblMobile = new JLabel("Mobile:9848022338");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobile.setBounds(482, 64, 126, 32);
		panel.add(lblMobile);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 125, 813, 437);
		panel_1.setBackground(new Color(211, 211, 211));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(143, 188, 143));
		panel_2.setBounds(10, 11, 785, 418);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		inv_no = new JTextField();
		inv_no.setBounds(150, 89, 141, 20);
		panel_2.add(inv_no);
		inv_no.setColumns(10);
		
		
		JLabel lblInvoiceNo = new JLabel("INVOICE NO:");
		lblInvoiceNo.setBounds(9, 86, 109, 26);
		
		
		panel_2.add(lblInvoiceNo);
		
		JLabel lblInvoiceDate = new JLabel(" DATE:");
		lblInvoiceDate.setBounds(422, 92, 101, 14);
		
		panel_2.add(lblInvoiceDate);

		
		JLabel lblCustomername = new JLabel("  CUSTOMER  NAME:");
		lblCustomername.setBounds(9, 147, 118, 20);
		panel_2.add(lblCustomername);
		
		cus_name = new JTextField();
		cus_name.setBounds(142, 142, 200, 31);
		panel_2.add(cus_name);
		cus_name.setColumns(10);
		
		JLabel lblCustomerMobile = new JLabel("CUSTOMER MOBILE:");
		lblCustomerMobile.setBounds(422, 156, 128, 14);
		panel_2.add(lblCustomerMobile);
		
		cus_mob = new JTextField();
		cus_mob.setBounds(555, 142, 156, 31);
		panel_2.add(cus_mob);
		cus_mob.setColumns(10);
		class JTextFieldLimit extends PlainDocument {
			  private int limit;
			  JTextFieldLimit(int limit) {
			    super();
			    this.limit = limit;
			  }

			  JTextFieldLimit(int limit, boolean upper) {
			    super();
			    this.limit = limit;
			  }

			  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
			    if (str == null)
			      return;

			    if ((getLength() + str.length()) <= limit) {
			      super.insertString(offset, str, attr);
			    }
			  }
			}
		
		cus_mob.setDocument(new JTextFieldLimit(10));
		
		JLabel lblProductname = new JLabel("PRODUCT NAME");
		lblProductname.setBounds(9, 251, 101, 31);
		panel_2.add(lblProductname);
		
		
		JLabel lblProductcode = new JLabel("PRODUCT CODE:");
		lblProductcode.setBounds(427, 256, 111, 20);
		panel_2.add(lblProductcode);
		
		tpcode = new JTextField();
		tpcode.setBounds(578, 256, 118, 20);
		panel_2.add(tpcode);
		tpcode.setColumns(10);
		
		JLabel lblAmount = new JLabel("PRICE");
		lblAmount.setBounds(9, 293, 62, 31);
		panel_2.add(lblAmount);
		
		tprice = new JTextField();
		tprice.setBounds(142, 298, 100, 20);
		panel_2.add(tprice);
		tprice.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setBounds(422, 301, 72, 14);
		panel_2.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(560, 298, 109, 20);
		panel_2.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("GST:");
		lblNewLabel_1.setBounds(12, 355, 62, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(105, 275, 46, 14);
		panel_2.add(label_1);
		
		gst = new JTextField();
		gst.setBounds(142, 360, 86, 20);
		gst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    
			      
			    String x= tprice.getText();
				 int a= Integer.parseInt(x);
				
				 
				 String y=(String)quantity.getText();
				 int b= Integer.parseInt(y);
				 
				 
				 String w= gst.getText();
				int g=Integer.parseInt(w);
				
				  int k= a*g/(g+100);
				
		         int r= k +a;
		         
		         int t =r * b;
				 
				 String z=Integer.toString(t);
				 totalorder.setText(z);
			     
			     
			     
			
			}
			
		});
		gst.setText("18");
		panel_2.add(gst);
		gst.setColumns(10);
		
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT");
		lblTotalAmount.setBounds(422, 363, 86, 14);
		panel_2.add(lblTotalAmount);
		
		
		//introduction to git
		totalorder = new JTextField();
		totalorder.setBounds(555, 360, 113, 20);
		panel_2.add(totalorder);
		totalorder.setColumns(10);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(28, 52, 575, -49);
		panel_2.add(panel_3);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(292, 9, 255, 40);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JRadioButton reg = new JRadioButton("REGULAR");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInvoiceNo.setVisible(true);
				inv_no.setVisible(true);
			
			}
			
			
		});
		
		reg.setBounds(6, 7, 109, 23);
		panel_4.add(reg);
		
		JRadioButton est = new JRadioButton("ESTIMATION");
		est.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblInvoiceNo.setVisible(false);
				inv_no.setVisible(false);
				
			}
		});
		est.setBounds(140, 7, 109, 23);
		panel_4.add(est);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(reg);
		bg.add(est);
		reg.setSelected(true);
		
		JDateChooser OrderDate = new JDateChooser();
		OrderDate.setBounds(555, 89, 141, 20);
		OrderDate.setDateFormatString("dd MM yyyy");
		
		panel_2.add(OrderDate);
		
		JLabel lblBillno = new JLabel("BILLNO");
		lblBillno.setBounds(28, 22, 46, 14);
		panel_2.add(lblBillno);
		
		bill_no = new JTextField();
		bill_no.setBounds(150, 19, 118, 20);
		panel_2.add(bill_no);
		bill_no.setColumns(10);
		
		tpname = new JTextField();
		tpname.setBounds(139, 253, 186, 26);
		panel_2.add(tpname);
		tpname.setColumns(10);
		
		JLabel lblProduct = new JLabel("PRODUCT");
		lblProduct.setBounds(9, 202, 93, 20);
		panel_2.add(lblProduct);
		
		JButton search_button = new JButton("search");
		search_button.setBounds(274, 203, 89, 19);
		search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection(  
							"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 

        // PreparedStatement st = con.prepareStatement("SELECT  * from product WHERE PRODUCTNAME LIKE '%'"+tpname.getText() +" % OR PRODUCTCODE LIKE % "+tpcode.getText()+"");
		// st =con.PreparedStatement(st);				
         String searchName =prodsearch.getText();
		 //PreparedStatement st = con.prepareStatement("select * FROM product where PRODUCTNAME LIKE '%' "+ tpname.getText()+ " OR  PRODUCTCODE LIKE '%'"+ tpcode.getText()+"  OR PRICE LIKE '%'"+tprice.getText()+" ");
			           
		PreparedStatement st = con.prepareStatement("select * FROM product where PRODUCTNAME ='"+ searchName+"' or  PRODUCTCODE='"+searchName+"' OR PRICE='"+searchName+"'" );
					//List<Strings> productsNames =new LinkedList<Strings>();
					ResultSet rs=st.executeQuery();  
					while(rs.next()){ 
						tpcode.setText(rs.getString(2));
						tpname.setText(rs.getString(1));
						tprice.setText(rs.getString(3));
						System.out.println(rs.getString(2)); 
						System.out.println(rs.getString(1)); 
						System.out.println(rs.getString(3)); 
						
					}  
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(search_button);
		
		prodsearch = new JTextField();
		prodsearch.setBounds(139, 202, 118, 20);
		panel_2.add(prodsearch);
		prodsearch.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(560, 9, 151, 46);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
	
		JLabel lblDate = new JLabel("date");
		lblDate.setBounds(10, 11, 141, 24);
		panel_6.add(lblDate);
		
		//void showDate()
		
			Date d=new Date();
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy     hh::mm::ss");
			lblDate.setText(s.format(d));
			
			JLabel lblDiscount = new JLabel("Discount");
			lblDiscount.setBounds(274, 363, 46, 14);
			panel_2.add(lblDiscount);
			
			tdis = new JTextField();
			tdis.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
				
					
					 String dis= tdis.getText();
					 int c= Integer.parseInt(dis);
					
					 
					 String price=(String)tprice.getText();
					 int d= Integer.parseInt(price);
					 
					 int w=d*(100-c)/100;
					 
					String p=Integer.toString(w);
					totalorder.setText(p);
					 }
			});
			tdis.setBounds(326, 363, 86, 20);
			panel_2.add(tdis);
			tdis.setColumns(10);
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(230, 589, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
						   Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection(  
									"jdbc:oracle:thin:@localhost:1521:orcl","system","Adminadmin20"); 
							//Statement smt=con.createStatement();
							    String insertData=("insert into  SYSTEM.BILLPAY values(?,?,?,?,?,?,?,?,?,?)");
								PreparedStatement ps= con.prepareStatement(insertData);
								ps.setString(1, inv_no.getText());
								
								
								
								
								
							    ps.setString(2, ((JTextField)OrderDate.getDateEditor().getUiComponent()).getText());
								//ps.setString(2, dateChooser.getDateFormatString());
								ps.setString(3, cus_name.getText());
								ps.setString(4, cus_mob.getText());
								ps.setString(5, tpname.getText());
								ps.setString(6,tpcode.getText());
								ps.setString(7, tprice.getText());
								ps.setString(8,quantity.getText());
								ps.setString(9, gst.getText());
		                        ps.setString(10,totalorder.getText());
		                     
								int inserted =ps.executeUpdate();
								 
								if(inserted>0) {
									
									JOptionPane.showMessageDialog(null, "Data Inserted sucessfully");
								}
				}	
							 catch(Exception e1) {
								e1.printStackTrace();
							} finally {
							
							
		                   }
		}
		});
		contentPane.add(btnSubmit);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(369, 589, 89, 23);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inv_no.setText("");
				//(JDateChooser) OrderDate).setText("");
				cus_name.setText("");
				cus_mob.setText("");
                prodsearch.setText("");
			    tpname.setText("");
				tpcode.setText("");
				quantity.setText("");
				tprice.setText("");
				gst.setText("");
				totalorder.setText("");
			}
		});
		contentPane.add(btnClear);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 623, 813, 127);
		panel_5.setBackground(new Color(0, 255, 255));
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"inv_no", "OrderDate", "cus_name", "cus_mob", "productname", "prod_code", "quantity", "amount", "gst", "ordertotal"},
			},
			new String[] {
				"inv_no", "OrderDate", "cus_name", "cus_mob", "productname", "prod_code", "quantity", "amount", "gst", "ordertotal"
			}
		));
		
		
		table.setBounds(32, 11, 756, 93);
		panel_5.add(table);
		
		JButton btnDispalyText = new JButton("dispaly text");
		btnDispalyText.setBounds(99, 589, 89, 23);
		btnDispalyText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
						
;						model.addRow(new Object[] {
						
						
						inv_no.getText(),
						OrderDate.getDate(),
						cus_name.getText(),
						cus_mob.getText(),
						//((JTextF) comboBox).getText(),
						
					     //comboBox.getComboBox(),
						tpname.getText(),
						tpcode.getText(),
						quantity.getText(),
						tprice.getText(),
						
						gst.getText(),
						
						//amnt.getText(),
						//disc_per.getText(),
						totalorder.getText()
					});
				}
		});
		contentPane.add(btnDispalyText);
		
		JButton btnDesc = new JButton("desc");
		btnDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 //close();
				
				
				
				
				
				
			 Description d=new Description();
			 d.setVisible(true);
			
			
			
			}
		});
		btnDesc.setBounds(496, 589, 89, 23);
		contentPane.add(btnDesc);
		
		

	}
}
