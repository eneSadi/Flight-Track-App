import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Flight_Track extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Flight> flights;
	private ArrayList<Capital> capitals;
	
	public Flight_Track(ArrayList<Flight> flights, ArrayList<Capital> capitals) throws HeadlessException {
		
		this.flights = flights;
		this.capitals = capitals;
		initComponents();
	}
                         
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        flight_no_textbox = new javax.swing.JTextField();
        airlines_textbox = new javax.swing.JTextField();
        landto_textbox = new javax.swing.JTextField();
        takentime_textbox = new javax.swing.JTextField();
        takeoff_textbox = new javax.swing.JTextField();
        tuesday = new javax.swing.JCheckBox();
        monday = new javax.swing.JCheckBox();
        saturday = new javax.swing.JCheckBox();
        wednesday = new javax.swing.JCheckBox();
        friday = new javax.swing.JCheckBox();
        thursday = new javax.swing.JCheckBox();
        sunday = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        flight_table = new javax.swing.JTable();
        add_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        departure_textbox = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        add_capital_textbox = new javax.swing.JTextField();
        addcapital_button = new javax.swing.JButton();
        delete_capital_textbox = new javax.swing.JTextField();
        delete_capital_button = new javax.swing.JButton();
        gotosim_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        simTime_textbox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        days_combo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Flight Track");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        jLabel1.setText("Flight Number:");

        jLabel2.setText("Name of Airlines: ");

        jLabel3.setText("Take off From:");

        jLabel4.setText("Land to:");

        jLabel5.setText("Taken Time: ");

        jLabel6.setText("Weekdays:");

        flight_no_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flight_no_textboxActionPerformed(evt);
            }
        });

        airlines_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlines_textboxActionPerformed(evt);
            }
        });

        tuesday.setText("Tuesday");
        tuesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayActionPerformed(evt);
            }
        });

        monday.setText("Monday");
        monday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayActionPerformed(evt);
            }
        });

        saturday.setText("Saturday");
        saturday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturdayActionPerformed(evt);
            }
        });

        wednesday.setText("Wednesyday");
        wednesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayActionPerformed(evt);
            }
        });

        friday.setText("Friday");
        friday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayActionPerformed(evt);
            }
        });

        thursday.setText("Thursday");
        thursday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursdayActionPerformed(evt);
            }
        });

        sunday.setText("Sunday");
        sunday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sundayActionPerformed(evt);
            }
        });

        flight_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Flight Number", "Name of Airlines", "Take off From", "Land to", "Taken Time", "Weekdays", "Departure", "Arrival"
            }
        ) {
            
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        flight_table.getTableHeader().setReorderingAllowed(false);
        flight_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                flight_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(flight_table);

        add_button.setText("Add Flight");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        delete_button.setText("Delete Flight");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        update_button.setText("Update Flight");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jLabel7.setText("Departure Time:");

        add_capital_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_capital_textboxActionPerformed(evt);
            }
        });

        addcapital_button.setText("Add Capital");
        addcapital_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcapital_buttonActionPerformed(evt);
            }
        });

        delete_capital_textbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_capital_textboxActionPerformed(evt);
            }
        });

        delete_capital_button.setText("Delete Capital");
        delete_capital_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_capital_buttonActionPerformed(evt);
            }
        });

        gotosim_button.setText("GO TO SIMULATION --->");
        gotosim_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gotosim_buttonActionPerformed(evt);
            }
        });

        jLabel8.setText("Please write with the correct form 12:12:12");

        jLabel9.setText("Please write with the correct form 12:12:12");

        jLabel10.setText("Sim. Time:");

        days_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        days_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                days_comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(94, 94, 94)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(airlines_textbox)
                            .addComponent(takeoff_textbox)
                            .addComponent(takentime_textbox)
                            .addComponent(landto_textbox, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(flight_no_textbox, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(departure_textbox))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(monday, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wednesday, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thursday, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(saturday, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sunday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(update_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(friday, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(delete_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete_capital_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delete_capital_textbox))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addcapital_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(add_capital_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(days_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(simTime_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(gotosim_button, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(flight_no_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(airlines_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(takeoff_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(landto_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(takentime_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departure_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(monday)
                                    .addComponent(friday)))
                            .addComponent(add_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tuesday)
                                    .addComponent(saturday))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(wednesday)
                                    .addComponent(sunday))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursday)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(update_button)
                                .addGap(18, 18, 18)
                                .addComponent(delete_button)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_capital_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addcapital_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete_capital_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete_capital_button)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(simTime_textbox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(days_combo)
                                .addComponent(jLabel10)))
                        .addComponent(gotosim_button, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    } 
    
    private void days_comboActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }  
    
    private void flight_no_textboxActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void tuesdayActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void mondayActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void saturdayActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void wednesdayActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void fridayActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void thursdayActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void sundayActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void airlines_textboxActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                
    
    private void add_capital_textboxActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    } 
    
    private void delete_capital_textboxActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    } 

    private void flight_tableMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
    }  
	
    //Saat içeren text kutularının doğru formda olup olmadığını kontrol eder.
    public static boolean isCorrectForm(String tmp) {
		
		try {
			int h = Integer.parseInt(tmp.split(":")[0]);
			int m = Integer.parseInt(tmp.split(":")[1]);
			int s = Integer.parseInt(tmp.split(":")[2]);
			if(h < 24 && h >= 0 && m < 60 && m >= 0 && s <60 && s >= 0) {
				return true;
			}
		}catch(NumberFormatException e) {
			return false;
		}catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}
    
    //İşaretlenen checkbox'lara göre weekdays arraylist'ini oluşturur.
    public ArrayList<String> createWeekdays(){
        ArrayList<String> weekdays = new ArrayList<String>(7);
        if(monday.isSelected()){
            weekdays.add("Monday");
        }
        if(tuesday.isSelected()){
            weekdays.add("Tuesday");
        }
        if(wednesday.isSelected()){
            weekdays.add("Wednesday");
        }
        if(thursday.isSelected()){
            weekdays.add("Thursday");
        }
        if(friday.isSelected()){
            weekdays.add("Friday");
        }
        if(saturday.isSelected()){
            weekdays.add("Saturday");
        }
        if(sunday.isSelected()){
            weekdays.add("Sunday");
        }
        return weekdays; 
    }
    
    //Girilen şehirlerin listede olup olmadığı kontrol edilir. Varsa bu değişkenlere atılır.
    private Capital takeoffcity = null, landtocity = null;
    boolean isinCapitals(String takeoff, String landto) {
    	boolean ctrl1 = false, ctrl2 = false;
    	
    	for(Capital tmp : capitals) {
    		if(tmp.getName().equals(takeoff)) {
    			ctrl1 = true;
    			takeoffcity = tmp;
    		}
    		if(tmp.getName().equals(landto)) {
    			ctrl2 = true;
    			landtocity = tmp;
    		}
    	}
    	return (ctrl1 && ctrl2);
    }
   
    //Uçuş listesi üzerinde her değişiklik yapıldıktan sonra listeyi dosyaya baştan yazar.
    public void writeFile(ArrayList<Flight> flights) {
    	
    	String fileName = "src/flights.dat";
    	try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			writer.writeObject(flights);
			writer.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    //Şehir listesi üzerinde her değişiklik yapıldıktan sonra listeyi dosyaya baştan yazar.
    public void writeFileCapital(ArrayList<Capital> capitals) {
    	
    	String fileName = "src/capitals.dat";
    	try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));
			writer.writeObject(capitals);
			writer.close();
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    //Flight no'su verilen uçuşu listede bulup döndürür.
    public Flight findFlight(String no) {
    	for(Flight tmp : flights) {
    		if(tmp.getFlightNumber().equals(no)) {
    			return tmp;
    		}
    	}
    	return null;
    }
    
    ////İsmi verilen capital'i listede bulup döndürür.
    private Capital tmp_capital = null;
    public Capital findCapital(String tmp) {
    	for(Capital x : capitals) {
    		if(x.getName().equals(tmp)) {
    			tmp_capital = x;
    			return x;
    		}
    	}
    	return null;
    }
    
	//Arayüz üzerindeki tablo flights.dat dosyası okunarak doldurulur.
    @SuppressWarnings("unchecked")
	public void fillTable() {
    	DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
    	String fileName = "src/flights.dat";
    	ObjectInputStream reader;
		try {
			reader = new ObjectInputStream(new FileInputStream(fileName));
			ArrayList<Flight> flights = (ArrayList<Flight>)reader.readObject();
	    	for(Flight tmp : flights) {
	    		
				Object addThis[] = {tmp.getFlightNumber(), tmp.getNameOfAirlines(), tmp.getTakeoffFrom().getName(), tmp.getLandTo().getName(), String.valueOf(tmp.getTakenTime().getTime()).split(" ")[3], tmp.getWeekdays(),String.valueOf(tmp.getDeparture().getTime()).split(" ")[3], String.valueOf(tmp.getArrivalTime().getTime()).split(" ")[3]};
	        	model.addRow(addThis);
	    	}
	    	reader.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
    }
    
    //Uçuş ekleme işlemi gerekli kontrollerin ardından yapılır.
	private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        
        DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
        boolean ctrl;
        ctrl = (!monday.isSelected() && !tuesday.isSelected() && !wednesday.isSelected() && !thursday.isSelected() && !friday.isSelected() && !saturday.isSelected() && !sunday.isSelected());
        
        if(isCorrectForm(departure_textbox.getText()) && isCorrectForm(takentime_textbox.getText())) {
        	
        	if(flight_no_textbox.getText().trim().equals("") || airlines_textbox.getText().trim().equals("") || takeoff_textbox.getText().trim().equals("") || landto_textbox.getText().trim().equals("") || takentime_textbox.getText().trim().equals("") || departure_textbox.getText().trim().equals("") || ctrl){
        		JOptionPane.showMessageDialog(this, "Any box cannot be empty!");
        	}
        	else{
        		if(!takeoff_textbox.getText().equals(landto_textbox.getText())) {
        			if(findFlight((String)flight_no_textbox.getText()) == null) {
            		
        				if(isinCapitals(takeoff_textbox.getText(), landto_textbox.getText())) {
                    
        					Calendar departure = new GregorianCalendar();
        					departure.set(Calendar.HOUR_OF_DAY, Integer.parseInt(departure_textbox.getText().split(":")[0]));
        					departure.set(Calendar.MINUTE, Integer.parseInt(departure_textbox.getText().split(":")[1]));
        					departure.set(Calendar.SECOND, Integer.parseInt(departure_textbox.getText().split(":")[2]));
                    	
                    	
        					Calendar takentime = new GregorianCalendar();
        					takentime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(takentime_textbox.getText().split(":")[0]));
        					takentime.set(Calendar.MINUTE, Integer.parseInt(takentime_textbox.getText().split(":")[1]));
        					takentime.set(Calendar.SECOND, Integer.parseInt(takentime_textbox.getText().split(":")[2]));
                    	
                    	
        					Calendar arrival = new GregorianCalendar();
        					arrival.set(Calendar.HOUR_OF_DAY, departure.get(Calendar.HOUR_OF_DAY) + takentime.get(Calendar.HOUR_OF_DAY));
        					arrival.set(Calendar.MINUTE, departure.get(Calendar.MINUTE) + takentime.get(Calendar.MINUTE));
        					arrival.set(Calendar.SECOND, departure.get(Calendar.SECOND) + takentime.get(Calendar.SECOND));
                    	
                    	
        					JOptionPane.showMessageDialog(this, "Flight added successfully!");
                    	
        					Flight tmp = new Flight(arrival , departure, createWeekdays(), flight_no_textbox.getText(), airlines_textbox.getText(), takeoffcity, landtocity, takentime);
        					flights.add(tmp);
        					Object addThis[] = {tmp.getFlightNumber(), tmp.getNameOfAirlines(), tmp.getTakeoffFrom().getName(), tmp.getLandTo().getName(), String.valueOf(tmp.getTakenTime().getTime()).split(" ")[3], tmp.getWeekdays(),String.valueOf(tmp.getDeparture().getTime()).split(" ")[3], String.valueOf(tmp.getArrivalTime().getTime()).split(" ")[3]};                    	
        					model.addRow(addThis);
                    	
                        
        					writeFile(flights);
        				}
        				else {
        					JOptionPane.showMessageDialog(this, "We do not have airports in selected cities!");
        				}

        			}
        			else {
        				JOptionPane.showMessageDialog(this, "This flight nubmer has taken!");
        			}
        		}
        		else {
        			JOptionPane.showMessageDialog(this, "Capitals cannot be same!");
        		}    
        	}
        }
        else {
			JOptionPane.showMessageDialog(this, "Time boxes are not given the right form!");
        }
        
        monday.setSelected(false);
        tuesday.setSelected(false);
        wednesday.setSelected(false);
        thursday.setSelected(false);
        friday.setSelected(false);
        saturday.setSelected(false);
        sunday.setSelected(false);
        departure_textbox.setText("");
        flight_no_textbox.setText("");
        airlines_textbox.setText(""); 
        takeoff_textbox.setText("");
        landto_textbox.setText("");
        takentime_textbox.setText("");
    }                                          
    
	//Uçuş silme işlemini gerekli kontrollerin ardından yapılır.
    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
        int selected_row = flight_table.getSelectedRow();
        
        if(selected_row == -1){
            if(flight_table.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Table is empty!");
            }
            else{
                JOptionPane.showMessageDialog(this, "No selection row!");
            }
        }
        else{
            Flight tmp = findFlight((String)model.getValueAt(selected_row, 0));
            if(tmp != null) {
                model.removeRow(selected_row);
                JOptionPane.showMessageDialog(this, "Flight deleted successfully!");
            	flights.remove(tmp);
            }
            else {
            	JOptionPane.showMessageDialog(this, "Flight cannot find!");
            }
        }
        writeFile(flights);
    }                                             

    //Uçuş üzerinde güncelleme işlemi gerekli kontrollerin ardından yapılır.
	private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        DefaultTableModel model = (DefaultTableModel) flight_table.getModel();
        
        int selected_row = flight_table.getSelectedRow();
        
        if(selected_row == -1){
            if(flight_table.getRowCount() == 0){
                JOptionPane.showMessageDialog(this, "Table is empty!");
            }
            else{
                JOptionPane.showMessageDialog(this, "No selection row!");
            }
        }
        else{
        	if(isCorrectForm(departure_textbox.getText()) && isCorrectForm(takentime_textbox.getText())) {
        		boolean ctrl;
        		ctrl = (!monday.isSelected() && !tuesday.isSelected() && !wednesday.isSelected() && !thursday.isSelected() && !friday.isSelected() && !saturday.isSelected() && !sunday.isSelected());
        		if(flight_no_textbox.getText().trim().equals("") || airlines_textbox.getText().trim().equals("") || takeoff_textbox.getText().trim().equals("") || landto_textbox.getText().trim().equals("") || takentime_textbox.getText().trim().equals("") || departure_textbox.getText().trim().equals("") || ctrl){
        			JOptionPane.showMessageDialog(this, "Any box cannot be empty!");
        		}
        		else{
                
        			if(isinCapitals(takeoff_textbox.getText(), landto_textbox.getText())) {
        				Flight tmp = findFlight((String)model.getValueAt(selected_row, 0));
        				model.setValueAt(flight_no_textbox.getText(), selected_row, 0);
        				model.setValueAt(airlines_textbox.getText(), selected_row, 1);
        				model.setValueAt(takeoff_textbox.getText(), selected_row, 2);
        				model.setValueAt(landto_textbox.getText(), selected_row, 3);
        				model.setValueAt(takentime_textbox.getText(), selected_row, 4);
        				model.setValueAt(createWeekdays(), selected_row, 5);
        				model.setValueAt(departure_textbox.getText(), selected_row, 6);
                   
        				JOptionPane.showMessageDialog(this, "Selected row updated successfully!");
                    
        				if(tmp != null) {
                    	
        					Calendar departure = new GregorianCalendar();
        					departure.set(Calendar.HOUR_OF_DAY, Integer.parseInt(departure_textbox.getText().split(":")[0]));
        					departure.set(Calendar.MINUTE, Integer.parseInt(departure_textbox.getText().split(":")[1]));
        					departure.set(Calendar.SECOND, Integer.parseInt(departure_textbox.getText().split(":")[2]));

        					Calendar takentime = new GregorianCalendar();
        					takentime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(takentime_textbox.getText().split(":")[0]));
        					takentime.set(Calendar.MINUTE, Integer.parseInt(takentime_textbox.getText().split(":")[1]));
        					takentime.set(Calendar.SECOND, Integer.parseInt(takentime_textbox.getText().split(":")[2]));

        					Calendar arrival = new GregorianCalendar();
        					arrival.set(Calendar.HOUR_OF_DAY, departure.get(Calendar.HOUR_OF_DAY) + takentime.get(Calendar.HOUR_OF_DAY));
        					arrival.set(Calendar.MINUTE, departure.get(Calendar.MINUTE) + takentime.get(Calendar.MINUTE));
        					arrival.set(Calendar.SECOND, departure.get(Calendar.SECOND) + takentime.get(Calendar.SECOND));
                    
        					tmp.setArrivalTime(arrival);
        					tmp.setDeparture(departure);
        					tmp.setFlightNumber(flight_no_textbox.getText());
        					tmp.setLandTo(landtocity);
        					tmp.setNameOfAirlines(airlines_textbox.getText());
        					tmp.setTakenTime(takentime);
        					tmp.setTakeoffFrom(takeoffcity);
        					tmp.setWeekdays(createWeekdays());
        					model.setValueAt(String.valueOf(tmp.getArrivalTime().getTime()).split(" ")[3], selected_row, 7);
        					writeFile(flights);
        				}      
        			}
        			else {
        				JOptionPane.showMessageDialog(this, "We do not have airports in selected cities!");
        			}
        		} 
        	}
        	else {
    			JOptionPane.showMessageDialog(this, "Time boxes are not given the right form!");
        	}
        }

        monday.setSelected(false);
        tuesday.setSelected(false);
        wednesday.setSelected(false);
        thursday.setSelected(false);
        friday.setSelected(false);
        saturday.setSelected(false);
        sunday.setSelected(false);
        departure_textbox.setText("");
        flight_no_textbox.setText("");
        airlines_textbox.setText(""); 
        takeoff_textbox.setText("");
        landto_textbox.setText("");
        takentime_textbox.setText("");
    }                                             

	//Girilen şehir listede zaten yoksa listeye eklenir.
    private void addcapital_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	String name = add_capital_textbox.getText();
    	
    	if(!name.equals("")) {
    		if(findCapital(name) == null) {
            	Capital tmp = new Capital(name);
            	capitals.add(tmp);
            	writeFileCapital(capitals);
            	JOptionPane.showMessageDialog(this, "Airport added given capital successfully!");
        	}
        	else {
        		JOptionPane.showMessageDialog(this, "We have airport in given capital already!");
        	}	
        	
        	add_capital_textbox.setText("");
    	}
    } 
                                                         
    //Girilen şehir listede var ise silinir.
    private void delete_capital_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        String name = delete_capital_textbox.getText();
        if(!name.equals("")) {
        	if(findCapital(name) != null) {
        		capitals.remove(tmp_capital);
        		writeFileCapital(capitals);
        		JOptionPane.showMessageDialog(this, "Capital removed successfully!");
        	}
        	else {
        		JOptionPane.showMessageDialog(this, "There is no airport in this capital!");
        	}
        }    
        delete_capital_textbox.setText("");
    }                                                     

    //Girilen similasyon zamanı ve günü gerekli kontrollerden sonra alınır ve extratab nesnesi (GUI) oluşturulur.
    private void gotosim_buttonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	String box = simTime_textbox.getText();
    	
    	if(isCorrectForm(simTime_textbox.getText())){
    		if(box.equals("")) {
    			JOptionPane.showMessageDialog(this, "You have to set the Sim. Time!");
    		}
    		else {
    			Calendar simtime = Calendar.getInstance();
    			simtime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(simTime_textbox.getText().split(":")[0]));
    			simtime.set(Calendar.MINUTE, Integer.parseInt(simTime_textbox.getText().split(":")[1]));
    			simtime.set(Calendar.SECOND, Integer.parseInt(simTime_textbox.getText().split(":")[2]));
        	
    			String simDay = String.valueOf(days_combo.getSelectedItem());
        	
    			if(simDay.equals("Monday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 7);
    			}
    			else if(simDay.equals("Tuesday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 1);
    			}
    			else if(simDay.equals("Wednesday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 2);
    			}
    			else if(simDay.equals("Thursday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 3);
    			}
    			else if(simDay.equals("Friday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 4);
    			}
    			else if(simDay.equals("Saturday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 5);
    			}
    			else if(simDay.equals("Sunday")) {
    				simtime.set(Calendar.DAY_OF_WEEK, 6);
    			}
        	
    			extratab simGui = new extratab(flights, simtime);
    			simGui.fillTable();
    			simGui.setVisible(true);
    		}
    	}
    	else {
    		JOptionPane.showMessageDialog(this, "Time box is not given the right form!");
    		simTime_textbox.setText("");
    	}
    } 
    
                                           
    //Değişken tanımlamaları                     
    private javax.swing.JButton add_button;
    private javax.swing.JTextField add_capital_textbox;
    private javax.swing.JButton addcapital_button;
    private javax.swing.JTextField airlines_textbox;
    private javax.swing.JComboBox<String> days_combo;
    private javax.swing.JButton delete_button;
    private javax.swing.JButton delete_capital_button;
    private javax.swing.JTextField delete_capital_textbox;
    private javax.swing.JTextField departure_textbox;
    private javax.swing.JTextField flight_no_textbox;
    private javax.swing.JTable flight_table;
    private javax.swing.JCheckBox friday;
    private javax.swing.JButton gotosim_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField landto_textbox;
    private javax.swing.JCheckBox monday;
    private javax.swing.JCheckBox saturday;
    private javax.swing.JTextField simTime_textbox;
    private javax.swing.JCheckBox sunday;
    private javax.swing.JTextField takentime_textbox;
    private javax.swing.JTextField takeoff_textbox;
    private javax.swing.JCheckBox thursday;
    private javax.swing.JCheckBox tuesday;
    private javax.swing.JButton update_button;
    private javax.swing.JCheckBox wednesday;             
}
