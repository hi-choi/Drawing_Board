// 패키지 import
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Vector;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.File;
import java.io.FileNotFoundException;


public class drawing_board {
	static class MyGUI extends JFrame{
		MyGUI()
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//-------------------------  처음 시작 후 출력되는 메시지 창 관련 코드------------------------------//
			//messagebox를 통해 GUI의 이름을 입력받음.
			 String name=JOptionPane.showInputDialog("Click To Draw를 정말 실행하시겠습니까?\n"
			 		+ "올바른 동작이라면 "
			 		+ "Click To Draw의 이름을 입력한 후 확인 버튼을 눌러주세요.\n"
			 		+ "잘못된 동작이라면 취소 버튼 또는 X 버튼을 눌러주세요.");
	 		 String message=String.format("Click To Draw를 이용해 주셔서 감사합니다. 지금부터 %s를 만들기 시작합니다.",name);
	 		 if(name==null)
	 		 {
	 			 System.exit(0);
	 		 }
	 		 JOptionPane.showMessageDialog(null, message);
	 		 setTitle(name);
	 		//-------------------------- 상단의 메뉴바 설정-------------------------------------------//  		
	 		//메뉴바 색
	 		 Color colordesign = new Color(255,155,155);
	 	     Color VIOLET = new Color(128,0,128);
		     Color INDIGO = new Color(75,0,130);
	 		 
	 		//메뉴바
			JMenuBar menubar = new JMenuBar();
			JMenu file = new JMenu("File");
			JMenu edit = new JMenu("Edit");
			JMenu help = new JMenu("Help");
			
			//File 하위 메뉴 정의
			JMenuItem load = new JMenuItem("Load");
			JMenuItem save = new JMenuItem("Save");
			
			//File 메뉴 설정
			setJMenuBar(menubar);
			menubar.add(file);
			file.add(load);
			load.setBackground(colordesign);
			file.add(save);
			save.setBackground(colordesign);
			
			//저장 및 불러오기
			FileDialog fd = new FileDialog(this, "File", FileDialog.LOAD); 
			fd.setDirectory(System.getProperty("user.home")+"\\desktop");
			
			//Edit 메뉴 설정
			menubar.add(edit);
			//Edit 하위 메뉴 정의
			JMenuItem lattice = new JMenuItem("Lattice");
			JMenuItem background=new JMenu("Background");
	
			edit.add(lattice);
			edit.add(background);
		
			//Background 하위 메뉴 정의
		    JMenuItem backred = new JMenuItem("Red");
		    backred.setBackground(Color.red);
		    background.add(backred);
	        JMenuItem backorange = new JMenuItem("Orange");
	        backorange.setBackground(Color.orange);
	        background.add(backorange);
	        JMenuItem backyellow = new JMenuItem("Yellow");
	        backyellow.setBackground(Color.yellow);
	        background.add(backyellow);
	        JMenuItem backgreen= new JMenuItem("Green");
	        backgreen.setBackground(Color.green);
	        background.add(backgreen);
	        JMenuItem backblue=new JMenuItem("Blue");
	        backblue.setBackground(Color.blue);
	        background.add(backblue);
	        JMenuItem backindigo=new JMenuItem("Indigo");
	        backindigo.setBackground(INDIGO);
	        background.add(backindigo);
	        JMenuItem backviolet=new JMenuItem("Violet");
	        backviolet.setBackground(VIOLET);
	        background.add(backviolet);
	        JMenuItem backpink=new JMenuItem("Pink");
	        backpink.setBackground(Color.pink);
	        background.add(backpink);
	        JMenuItem backwhite=new JMenuItem("White");
	        backwhite.setBackground(Color.white);
	        background.add(backwhite);
	        JMenuItem backblack=new JMenuItem("Black");
	        backblack.setBackground(Color.black);
	        background.add(backblack);

			//Help 하위메뉴 정의
	        JMenuItem explanation = new JMenuItem("Explanation");
	        JMenuItem producer= new JMenuItem("Producer");
	        								
			//Help 메뉴 설정
			menubar.add(help);
			help.add(explanation);
			explanation.setBackground(colordesign);
			help.add(producer);
			producer.setBackground(colordesign);
			
			//--------------------------좌측의 패널 설정-------------------------------------------//
			//전체 툴바 ToolBar 정의
			//아래에 정의 할 tool1, tool2, tool3, tool4를 ToolBar위에 올려 놓는다.
			//그리고 그 위에 또 새로운 JPanel을 올리고 JButton을 추가 하였다.
			JPanel ToolBar = new JPanel();
			
			ToolBar.setBackground(Color.gray);
			ToolBar.setBorder(BorderFactory.createLoweredBevelBorder());
			ToolBar.setBorder(BorderFactory.createLineBorder(Color.gray, 3));
			
			//툴바1
			JPanel tool1 = new JPanel();
		    tool1.setBorder(BorderFactory.createTitledBorder(null, "Functions 1", TitledBorder.CENTER,
		               TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.ITALIC, 12), Color.black));
		    tool1.setLayout(new FlowLayout());
		    tool1.setPreferredSize(new Dimension(110, 70));
		    add(tool1);
		    tool1.setVisible(true);	         
		    Dimension IconSize = new Dimension(30,30);
		    Dimension IconSize1 = new Dimension(30,60);
		    Dimension IconSize2 = new Dimension(60,30);
		    
		    //Line 구역
		    JPanel Line = new JPanel(); //선 패널
	        Line.setBorder(BorderFactory.createTitledBorder(null, "Line", TitledBorder.ABOVE_TOP, TitledBorder.DEFAULT_POSITION));
	        tool1.add(Line);
	        Line.setLayout(new GridLayout(3,3));
	        Line.setVisible(true);
	         
	        //직선 그리기 버튼
	        JButton line = new JButton();
	        line.setBackground(colordesign);
	        Line.add(line);
	        line.setPreferredSize(IconSize);
	        line.setToolTipText("Straight");
	         // 자율그리기 버튼
	        JButton free = new JButton();
	        free.setBackground(colordesign);
	        Line.add(free);
	        free.setPreferredSize(IconSize);
	        free.setToolTipText("Pen");
	        // 선두께조절1 버튼
	        JButton thick1= new JButton();
	        thick1.setBackground(colordesign);
	        Line.add(thick1);
	        thick1.setPreferredSize(IconSize);
	        thick1.setToolTipText("Line size1");
	        // 선두께 조절2 버튼
	        JButton thick2= new JButton();
	        thick2.setBackground(colordesign);
	        Line.add(thick2);
	        thick2.setPreferredSize(IconSize);
	        thick2.setToolTipText("Line size2");
	        // 선두께 조절3 버튼
	        JButton thick3= new JButton();
	        thick3.setBackground(colordesign);
	        Line.add(thick3);
	        thick3.setPreferredSize(IconSize);
	        thick3.setToolTipText("Line size3");
	        // 선두께 조절4 버튼
	        JButton thick4= new JButton();
	        thick4.setBackground(colordesign);
	        Line.add(thick4);
	        thick4.setPreferredSize(IconSize);
	        thick4.setToolTipText("Line size4");
	         
	        //Shape 구역
	        JPanel shape = new JPanel();
	        shape.setBorder(BorderFactory.createTitledBorder(null,"Shape",TitledBorder.ABOVE_BOTTOM,TitledBorder.DEFAULT_POSITION));
	        shape.setLayout(new GridLayout(5,1));
	        shape.setVisible(true);
	        tool1.add(shape);
	        // 원 그리기버튼
	        JButton circle = new JButton();
	        circle.setBackground(colordesign);
	        shape.add(circle);
	        circle.setPreferredSize(IconSize2);
	        circle.setToolTipText("Circle");
	        //삼각형 그리기 버튼
	        JButton triangle = new JButton();
	        triangle.setBackground(colordesign);
	        shape.add(triangle);
	        triangle.setPreferredSize(IconSize2);
	        triangle.setToolTipText("Triangle");
	        // 사각형 그리기 버튼
	        JButton rect = new JButton();
	        rect.setBackground(colordesign);
	        shape.add(rect);
	        rect.setPreferredSize(IconSize2);
	        rect.setToolTipText("Rectangle");
	        // 둥근 사각형 그리기 버튼
	        JButton roundrect = new JButton();
	        roundrect.setBackground(colordesign);
	        shape.add(roundrect);
	        roundrect.setPreferredSize(IconSize2);
	        roundrect.setToolTipText("Rounded rectangle");
	         // 오각형 그리기 버튼
	        JButton pentagon = new JButton();
	        pentagon.setBackground(colordesign);
	        shape.add(pentagon);
	        pentagon.setPreferredSize(IconSize2);
	        pentagon.setToolTipText("Pentagon");

	        
	        //툴바 2
			JPanel tool2 = new JPanel();
		    tool2.setBorder(BorderFactory.createTitledBorder(null, "Functions 2", TitledBorder.CENTER,
		               TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.ITALIC, 12), Color.black));
		    tool2.setLayout(new FlowLayout());
		    tool2.setPreferredSize(new Dimension(110, 70));
		    add(tool2);
		    tool2.setVisible(true);	         
		    
	        //지우개 구역
	        JPanel earsers= new JPanel();
	        earsers.setBorder(BorderFactory.createTitledBorder(null,"Eraser",TitledBorder.ABOVE_BOTTOM,TitledBorder.DEFAULT_POSITION));
	        earsers.setVisible(true);
	        earsers.setLayout(new GridLayout(2,30));
	        tool2.add(earsers);
	        //지우개 버튼
	        JButton er = new JButton();
	        er.setBackground(colordesign);
	        earsers.add(er);
	        er.setPreferredSize(IconSize);
	        er.setToolTipText("Eraser");
	         //지우개 size up 버튼
	        JButton eraseUp = new JButton();
	        eraseUp.setBackground(colordesign);
	        earsers.add(eraseUp);
	        eraseUp.setPreferredSize(IconSize);
	        eraseUp.setToolTipText("Eraser size Up");
	         // 지우개 size down 버튼
	        JButton eraseDown = new JButton();
	        eraseDown.setBackground(colordesign);
	        earsers.add(eraseDown);
	        eraseDown.setPreferredSize(IconSize);
	        eraseDown.setToolTipText("Erase size Down");
	         // 모두 지우개 버튼
	        JButton clear = new JButton();
	        clear.setBackground(colordesign);
	        earsers.add(clear);
	        clear.setPreferredSize(IconSize);
	        clear.setToolTipText("All remove");
	           
	        //선택 후 이동 구역
	        JPanel mv = new JPanel();
	        mv.setBorder(BorderFactory.createTitledBorder(null,"Move",TitledBorder.ABOVE_BOTTOM,TitledBorder.DEFAULT_POSITION));
	        mv.setVisible(true);
	        mv.setLayout(new GridLayout(1,1));
	        tool2.add(mv);
	        // 선택 후 이동 버튼
	        JButton move= new JButton();
	        move.setBackground(colordesign);
	        mv.add(move);
	        move.setPreferredSize(IconSize2);
	        move.setToolTipText("Move");
	        // 선택 후 복사 구역
	        JPanel mv2 = new JPanel();
	        mv2.setBorder(BorderFactory.createTitledBorder(null,"Copy",TitledBorder.ABOVE_BOTTOM,TitledBorder.DEFAULT_POSITION));
	        mv2.setVisible(true);
	        mv2.setLayout(new GridLayout(1,1));
	        tool2.add(mv2);
	        // 선택 후 복사 버튼
	        JButton copy= new JButton();
	        copy.setBackground(colordesign);
	        mv2.add(copy);         
	        copy.setPreferredSize(IconSize2);
	        copy.setToolTipText("Copy");
	        // Text 디자인 패널
	        JPanel Text = new JPanel();
	        Text.setBorder(BorderFactory.createTitledBorder(null,"Text",TitledBorder.ABOVE_BOTTOM,TitledBorder.DEFAULT_POSITION));
	        Text.setLayout(new GridLayout(1,1));
	        Text.setVisible(true);
	        tool2.add(Text);
	        // Text 버튼
	        JButton text = new JButton();
	        text.setBackground(colordesign);
	        Text.add(text);
	        text.setPreferredSize(IconSize2);
	        text.setToolTipText("Text");	        
	        //툴바 3
			JPanel tool3 = new JPanel();
		    tool3.setBorder(BorderFactory.createTitledBorder(null, "Functions 3", TitledBorder.CENTER,
		               TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.ITALIC, 12), Color.black));
		    tool3.setLayout(new FlowLayout());
		    tool3.setPreferredSize(new Dimension(110, 70));
		    add(tool3);
		    tool3.setVisible(true);	         

		    /*선택 구역*/
	        JPanel choice = new JPanel();
	        choice.setBorder(BorderFactory.createTitledBorder(null,"Choice",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
	        choice.setLayout(new GridLayout(1,1));
	        choice.setVisible(true);
	        tool3.add(choice);
	        //영역 선택 버튼
	        JButton cho= new JButton();
	        cho.setBackground(colordesign);
	        choice.add(cho);
	        cho.setPreferredSize(IconSize2);
	        cho.setToolTipText("Drag area");
		    
	        /*회전 구역*/
	        JPanel rotate = new JPanel();
	        rotate.setBorder(BorderFactory.createTitledBorder(null,"Rotate",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
	        rotate.setLayout(new GridLayout(1,2));
	        rotate.setVisible(true);
	        tool3.add(rotate);
	        // 왼쪽으로 90도 회전 버튼
	        JButton turnleft= new JButton();
	        turnleft.setBackground(colordesign);
	        rotate.add(turnleft);         
	        turnleft.setPreferredSize(IconSize1);
	        turnleft.setToolTipText("Rotate Left.");
	        // 오른쪽으로 90도 회전 버튼
	        JButton turnright= new JButton();
	        turnright.setBackground(colordesign);
	        rotate.add(turnright);         
	        turnright.setPreferredSize(IconSize1);
	        turnright.setToolTipText("Rotate Right.");
	        
	        /*대칭 구역*/
	        JPanel flip = new JPanel();
	        flip.setBorder(BorderFactory.createTitledBorder(null,"Flip",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
	        flip.setLayout(new GridLayout(1,2));
	        flip.setVisible(true);
	        tool3.add(flip);
	        // 상하 반전 버튼
	        JButton updown= new JButton();
	        updown.setBackground(colordesign);
	        flip.add(updown);         
	        updown.setPreferredSize(IconSize);
	        updown.setToolTipText("Upside down");
	        //좌우 반전 버튼
	        JButton leftright= new JButton();
	        leftright.setBackground(colordesign);
	        flip.add(leftright);         
	        leftright.setPreferredSize(IconSize);
	        leftright.setToolTipText("Symmetry");
	        
	        //툴바 4
			JPanel tool4 = new JPanel();
		    tool4.setBorder(BorderFactory.createTitledBorder(null, "Functions 4", TitledBorder.CENTER,
		               TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.ITALIC, 12), Color.black));
		    tool4.setLayout(new FlowLayout());
		    tool4.setPreferredSize(new Dimension(110, 70));
		    add(tool4);
		    tool4.setVisible(true);	  
		    
		    /*기타 구역*/
	        JPanel other = new JPanel();
	        other.setBorder(BorderFactory.createTitledBorder(null,"Fill",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
	        other.setLayout(new GridLayout(1,1));
	        other.setVisible(true);
	        tool4.add(other);
	        
		    //채우기
	        JButton fill= new JButton();
	        fill.setBackground(colordesign);
	        other.add(fill);
	        fill.setPreferredSize(IconSize2);
	        fill.setToolTipText("Fill color");

	        //색 구역
		    JPanel colors = new JPanel();
		    colors.setBorder(BorderFactory.createTitledBorder(null,"Color",TitledBorder.DEFAULT_JUSTIFICATION,TitledBorder.DEFAULT_POSITION));
		    colors.setLayout(new GridLayout(5,2));
		    colors.setVisible(true);
		    tool4.add(colors);
		    // Color 패널에  색 디자인 크기 조정     
		    Dimension colorsize = new Dimension(30,30);
	        // 빨간색 버튼
		    JButton red = new JButton();
	        red.setBackground(Color.red);
	        colors.add(red); 
	        red.setToolTipText("Red");
	        red.setPreferredSize(colorsize); 
		    // 남색 버튼
	        JButton indigo = new JButton();
	        indigo.setBackground(INDIGO);
	        colors.add(indigo); 
	        indigo.setToolTipText("Indigo");
	        indigo.setPreferredSize(colorsize);
	        // 주황색 버튼
	        JButton orange = new JButton();
	        orange.setBackground(Color.orange);
	        colors.add(orange);
	        orange.setToolTipText("Orange");
	        orange.setPreferredSize(colorsize);
	        // 보라색 버튼
	        JButton violet = new JButton();
	        violet.setBackground(VIOLET);
	        colors.add(violet); 
	        violet.setToolTipText("Violet");
	        violet.setPreferredSize(colorsize);
	        // 노란색 버튼
	        JButton yellow = new JButton();
	        yellow.setBackground(Color.YELLOW);
	        colors.add(yellow);
	        yellow.setToolTipText("Yellow");
	        yellow.setPreferredSize(colorsize);
	         // 초록색 버튼
	        JButton green = new JButton();
	        green.setBackground(Color.green);
	        colors.add(green);
	        green.setToolTipText("Green");
	        green.setPreferredSize(colorsize);
	        //분홍색 버튼
	        JButton pink = new JButton();
	        pink.setBackground(Color.pink);
	        colors.add(pink);
	        pink.setToolTipText("Pink");
	        pink.setPreferredSize(colorsize);
	        // 파랑색 버튼
	        JButton blue = new JButton();
	        blue.setBackground(Color.BLUE);
	        colors.add(blue); 
	        blue.setToolTipText("Blue");
	        blue.setPreferredSize(colorsize);
	         //흰색 버튼              
	        JButton white = new JButton();
		    white.setBackground(Color.white);
		    colors.add(white);
		    white.setToolTipText("White");
		    white.setPreferredSize(colorsize);    
		     //검은색 버튼    
		    JButton black = new JButton();
		    black.setBackground(Color.black);
		    colors.add(black);
		    black.setToolTipText("black");
		    black.setPreferredSize(colorsize);
		    // 툴바  디자인 설정
		    ToolBar.setLayout(new GridLayout(2,2));
		    ToolBar.add(tool1);
		    ToolBar.add(tool2);
		    ToolBar.add(tool3);
		    ToolBar.add(tool4);
		    		    
		    // 툴바 위치 조정
		    add(ToolBar,BorderLayout.WEST);
	        // JFRame에 DrawPanel 추가
		    DrawPanel dp = new DrawPanel();
			this.add(dp);
			// DrawPanel 사이즈 조정
			setSize(1000, 1000);
			setVisible(true);
			//----------------------이벤트 리스너 생성 -------------------------------------//
			/*그리기 도구 이벤트*/		
			circle.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 1;
				}
			});
			triangle.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 2;
				}
			});
			rect.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 3;
				}
			});
			roundrect.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 4;
				}
			});
			pentagon.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 5;
				}
			});
			line.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 6;
				}
			});
			free.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 7;
				}
			});
			text.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 8;
					dp.Text = null;
					repaint();
				}
			});
			/*파일 메뉴 관련 이벤트*/
			// 불러오기 이벤트
			load.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					fd.show();
					dp.file = fd.getDirectory() + fd.getFile();
					dp.select = 9;
				}
			});
			// 저장 이벤트
			save.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					if(fd.getFile() == null){
						fd.show();
					}
					
					if(!fd.getFile().contains(".")){
						fd.setFile(fd.getFile()+".jpg");
					}
					dp.file = fd.getDirectory() + fd.getFile();
					dp.select = 10;
					repaint();
				}
			});
			
			/*지우기 도구 관련 이벤트*/
			er.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 12;
				}
			});
			eraseUp.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.eraseSize = dp.eraseSize+5;
				}
			});
			eraseDown.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
				
					if(dp.eraseSize < 10)
		             {
		                System.out.println("지우개 크기가 너무 작습니다.");
		                dp.eraseSize=5;
		             }
		                else 
		             {
		                dp.eraseSize = dp.eraseSize - 5;
		             }
				}
			});
	        // 선택 후 복사
	        copy.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent e) {
	        		dp.select = 18;
	        	}
	        });
	        // 선택 후 이동
	        move.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent e) {
	        		dp.select = 19;
	        	}
	        });	

			
			/*채우기 */
			fill.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 15;
				}
			});
			
			/*모두 지우기 */
			clear.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
					dp.select=16;
				}
			});
			//격자
			lattice.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					dp.select=17;
					repaint(); // 수정 준혁

				}
			});
			
			//선택
			cho.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 20;
	
				}
			});
			//회전
			turnleft.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 21;	
					dp.repaint();
				}
			});
			turnright.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 22;
					dp.repaint();
				}
			});
			//대칭
			updown.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 23;
					dp.repaint();
				}
			});
			leftright.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					dp.select = 24;
					dp.repaint();
				}
			});
			
			/*도움말 메뉴*/
			explanation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String help = String.format("<Click To Draw>\n" +
							"해당 프로그램은 마우스로 Click 함으로써 동작합니다.\n "
							+ "Click To Draw는 처음 실행시 GUI를 실행시킬 것인지 묻는 창이 나타납니다.\n"
							+ "Click To Draw를 실행시키고자 한다면 Click To Draw의 이름을 입력해주시고 Yes 버튼을 눌러주시면 프로그램이 실행됩니다.\n"
							+ "만약 Click To Draw를 실행시키고자 하지 않는 다면 No 버튼을 눌러 주시면 됩니다.\n"
							+ "[파일 메뉴]\n"
							+ "외부의 파일을 불러오는 Load 기능과 작업한 파일을 저장하는 Save 기능을 지원합니다.\n" 
							+ "[편집 메뉴]\n"
							+ "빨간색,주황색,노랑색,초록색,파란색,남색,보라색,분홍색,하얀색,검은색 총 10가지 색의 배경을 선택할 수 있습니다. \n"
							+ "격자를 사용할 수 있습니다. 격자의 색은 Function 4의 Color에서 지정할 수 있습니다.\n"
							+ "[도움말 메뉴]\n"
							+ "Explanation은 해당 프로그램에 대한 도움말을 제공합니다. Producer은 해당 프로그램의 제작자에 대한 정보를 제공합니다.\n"
							+ "[Function 1]\n"
							+ "1. Line : 직선, 자율곡선(펜) 그리기 도구를 지원하고 선 두께를 조절할 수 있습니다.\n"
							+ "2. Shape : 원, 삼각형, 사각형, 모서리가 둥근 사각형, 오각형 그리기 도구를 지원합니다.\n"
							+ "3. Text : 처음 클릭시 글자를 입력할 수 있는 창이 실행됩니다. 글자를 입력한 후 원하는 위치에 마우스를 클릭하면 해당 글자를 입력할 수 있습니다.\n"
							+ "[Function 2]\n"
							+ "1. Erasesr : 지우개를 사용할 수 있으며 지우개의 사이즈를 조절할 수 있습니다. 그리고 화면에 있는 그림을 한꺼번에 모두 지우는 것도 가능합니다.\n"
							+ "2. Move : 원하는 영역을 선택한 후 해당 영역의 그림을 이동할 수 있습니다.\n"
							+ "3. Copy : 원하는 영역을 선택한 후 해당 영역의 그림을 복사할 수 있습니다.\n"
							+ "[Function 3]\n"
							+ "1. Choice : Function 3의 기능을 사용하기 위해서 선행되어야하는 기능입니다. 원하는 영역을 드래그 함으로써 선택할 수 있습니다.\n"
							+ "2. Rotate : 좌측으로 회전, 우측으로 회전 기능을 지원합니다. 해당 기능을 실행하고자 한다면 Choice 기능을 실행해 영역을 선택하는 직업이 선행되어야 합니다.\n"
							+ "3. Flip : 좌우 대칭, 상하 대칭 기능을 지원합니다. 해당 기능을 실행하고자 한다면 Choice 기능을 실행해 영역을 선택하는 작업이 선행되어야 합니다.\n"
							+ "[Function 4]\n"
							+ "1. Fill : Function 1의 shape를 통해 그린 도형에 색을 채울 수 있는 기능입니다.\n"
							+ "2. Color : 빨간색,주황색,노랑색,초록색,파란색,남색,보라색,분홍색,하얀색,검은색 총 10가지 색을 선택할 수 있습니다."
								
							);
					
					JTextArea area = new JTextArea();
					area.setEditable(false);
					area.setText(help);	

					JScrollPane scroll = new JScrollPane(area);
					JFrame helpFrame = new JFrame("Explanation");

					helpFrame.add(scroll);//스크롤 추가
					helpFrame.setDefaultCloseOperation(JOptionPane.CANCEL_OPTION);//프레임 닫기버튼시 수행설정
					helpFrame.setSize(500, 300);//프레임크기
					helpFrame.setVisible(true);

				}
			});
			// 제작자 관련 이벤트
			producer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, 
									"소프트웨어학과         2016125030  서한나\n"+
									"물류전공                    2013122214  이준혁\n"+
									"글로벌항공경영학과  2017126050  서혜민"
									,"Producer", JOptionPane.INFORMATION_MESSAGE);

				}
			});
			/*선 굵기 관련 이벤트*/
			thick1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					dp.thick=1;
				}
			});
			
			thick2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					dp.thick=2;
				}
			});
			
			thick3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					dp.thick=3;
				}
			});
			
			thick4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					dp.thick=4;
				}
			});

			/*배경 관련 이벤트*/
			backred.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
		               dp.back = 1;
		               System.out.println(dp.back);
		               repaint();
					
					}
				});
			backorange.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 2;
		               System.out.println(dp.back); 
		               repaint();
			      }
			   }); 
			backyellow.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 3;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backgreen.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 4;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backblue.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 5;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backindigo.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 6;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backviolet.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 7;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backpink.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 8;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backwhite.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 9;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			backblack.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0){
		               dp.back = 10;
		               System.out.println(dp.back);
		               repaint();
			      }
			   }); 
			/*색 도구 관련 이벤트*/
	        red.addMouseListener(new MouseAdapter(){
	            public void mouseClicked(MouseEvent e){
	               dp.color = 1;
	            }
	         });  
	        orange.addMouseListener(new MouseAdapter(){
	             public void mouseClicked(MouseEvent e){
	                dp.color = 2;
	             }
	          });
	        yellow.addMouseListener(new MouseAdapter(){
	             public void mouseClicked(MouseEvent e){
	                dp.color = 3;
	             }
	          });
	        green.addMouseListener(new MouseAdapter(){
	            public void mouseClicked(MouseEvent e){
	               dp.color = 4;
	            }
	         });
	        blue.addMouseListener(new MouseAdapter(){
	            public void mouseClicked(MouseEvent e){
	               dp.color = 5;
	            }
	         });
	        indigo.addMouseListener(new MouseAdapter(){
	             public void mouseClicked(MouseEvent e){
	                dp.color = 6;
	             }
	          });
	        violet.addMouseListener(new MouseAdapter(){
	             public void mouseClicked(MouseEvent e){
	                dp.color = 7;
	             }
	          });
	        pink.addMouseListener(new MouseAdapter(){
	             public void mouseClicked(MouseEvent e){
	                dp.color = 8;
	             }
	          });
	        white.addMouseListener(new MouseAdapter(){
	             public void mouseClicked(MouseEvent e){
	                dp.color = 9;
	             }
	          });
	        black.addMouseListener(new MouseAdapter(){
	            public void mouseClicked(MouseEvent e){
	               dp.color = 10;
	            }
	         });

		}
	}
	static class DrawPanel extends JPanel implements MouseListener, MouseMotionListener{
		// 마우스의 좌표 값을 얻기 위한 변수
		Vector points;
		Vector points2;
		Image img = null;
		//도형 크기 설정 사용
		int width = 0;
		int height = 0;
		int count = 0;
		// 복사 및 이동 관련 변수
		int copyCheck = 0;
		int copyX = 0;
		int copyY = 0;
		int copyWidth = 0;
		int copyHeight =0; 	
		//기능 선택 사용
		int select = 0;
		//색 선택 사용
		int color = 0;
		//배경색 선택
		int back = 0; // 수정 준혁
		//마우스 이벤트 발생 시 사용
		Point p1, p2;
		//글상자 입력
		String Text;
		//지우개 사이즈
		int eraseSize;
		//파일 메뉴 기능 구현에 사용
		String file;
		//도형 임시저장을 위한  변수
		save_shape sv[];
		int num = 0;
		//버퍼(배경색+1)
		BufferedImage x;
		BufferedImage C1;
		BufferedImage C2;
		BufferedImage C3;
		BufferedImage C4;
		BufferedImage C5;
		BufferedImage C6;
		BufferedImage C7;
		BufferedImage C8;
		BufferedImage C9;
		BufferedImage C10;
		//도형 회전, 대칭에 관여
		BufferedImage rotate;
		BufferedImage rotate2;
		BufferedImage hid;
		int x_,y_;
		//선 굵기
		int thick;
		//남색,보라 두 종류의 색은 GUI에서 바로 지원되지 않으므로 미리 정의.
	    private final static Color VIOLET = new Color(128,0,128);
	    private final static Color INDIGO = new Color(75,0,130);
		

	    
	    DrawPanel(){
	    	//초기 화면
	    	select=-1;
	    	//마우스 위치
			points = new Vector();
			points2= new Vector();
			//임시 저장 공간
			sv = new save_shape[500];
			//지우개 사이즈 기본 설정
			eraseSize=15;
			//마우스핸들러 사용
			addMouseListener(this);
			addMouseMotionListener(this);
			// 버퍼이미지 선언
			x = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C1 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C2 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C3 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C4 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C5 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C6 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C7 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C8 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C9 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			C10 = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
			hid=new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);
		}
		public void paint(Graphics r){
			//페인트 시작
			super.paint(r);
		    
			//선 굵기
		    Graphics2D L=(Graphics2D)r;
		    
			int i;
			// 버퍼이미지에 대한 그래픽 
			Graphics g = x.getGraphics();
			Graphics g1 = C1.getGraphics();
			Graphics g2 = C2.getGraphics();
			Graphics g3 = C3.getGraphics();
			Graphics g4 = C4.getGraphics();
			Graphics g5 = C5.getGraphics();
			Graphics g6 = C6.getGraphics();
			Graphics g7 = C7.getGraphics();
			Graphics g8 = C8.getGraphics();
			Graphics g9 = C9.getGraphics();
			Graphics g10 = C10.getGraphics();
			
			//---------------------- 배경색에 따라 다른 버퍼이미지를 실행----------------------//
			switch(back) {
			case 0: 
				r.drawImage(x, 0, 0, this);
				break;
			case 1:
				r.drawImage(C1, 0, 0, this);
				break;
			case 2:
				r.drawImage(C2, 0, 0, this);
				break;
			case 3:
				r.drawImage(C3, 0, 0, this);
				break;
			case 4:
				r.drawImage(C4, 0, 0, this);
				break;
			case 5:
				r.drawImage(C5, 0, 0, this);
				break;
			case 6:
				r.drawImage(C6, 0, 0, this);
				break;
			case 7:
				r.drawImage(C7, 0, 0, this);
				break;
			case 8:
				r.drawImage(C8, 0, 0, this);
				break;
			case 9:
				r.drawImage(C9, 0, 0, this);
				break;
			case 10:
				r.drawImage(C10, 0, 0, this);
				break;
		} 
			

	        //-----------------------도형색 설정--------------------------------//
            if (color == 0) {
                r.setColor(Color.black); 
                g.setColor(Color.black);
                g1.setColor(Color.black);
                g2.setColor(Color.black);
                g3.setColor(Color.black);
                g4.setColor(Color.black);
                g5.setColor(Color.black);
                g6.setColor(Color.black);
                g7.setColor(Color.black);
                g8.setColor(Color.black);
                g9.setColor(Color.black);
                g10.setColor(Color.black);
             
        }
            if (color == 1) {
                r.setColor(Color.red); 
                g.setColor(Color.red);
                g1.setColor(Color.red);
                g2.setColor(Color.red);
                g3.setColor(Color.red);
                g4.setColor(Color.red);
                g5.setColor(Color.red);
                g6.setColor(Color.red);
                g7.setColor(Color.red);
                g8.setColor(Color.red);
                g9.setColor(Color.red);
                g10.setColor(Color.red);
             
        }  
            if (color == 2) {
                r.setColor(Color.orange);
                g.setColor(Color.orange);
                g1.setColor(Color.orange);
                g2.setColor(Color.orange);
                g3.setColor(Color.orange);
                g4.setColor(Color.orange);
                g5.setColor(Color.orange);
                g6.setColor(Color.orange);
                g7.setColor(Color.orange);
                g8.setColor(Color.orange);
                g9.setColor(Color.orange);
                g10.setColor(Color.orange);
             
        }       
            if (color == 3) {
                r.setColor(Color.yellow);
                g.setColor(Color.yellow);
                g1.setColor(Color.yellow);
                g2.setColor(Color.yellow);
                g3.setColor(Color.yellow);
                g4.setColor(Color.yellow);
                g5.setColor(Color.yellow);
                g6.setColor(Color.yellow);
                g7.setColor(Color.yellow);
                g8.setColor(Color.yellow);
                g9.setColor(Color.yellow);
                g10.setColor(Color.yellow);
             
        }       
            if (color == 4) {
                r.setColor(Color.green);
                g.setColor(Color.green);
                g1.setColor(Color.green);
                g2.setColor(Color.green);
                g3.setColor(Color.green);
                g4.setColor(Color.green);
                g5.setColor(Color.green);
                g6.setColor(Color.green);
                g7.setColor(Color.green);
                g8.setColor(Color.green);
                g9.setColor(Color.green);
                g10.setColor(Color.green);
        }
            if (color == 5) {
                r.setColor(Color.blue);  
                g.setColor(Color.blue);
                g1.setColor(Color.blue);  
                g2.setColor(Color.blue);
                g3.setColor(Color.blue);  
                g4.setColor(Color.blue);
                g5.setColor(Color.blue);  
                g6.setColor(Color.blue);
                g7.setColor(Color.blue);  
                g8.setColor(Color.blue);
                g9.setColor(Color.blue);  
                g10.setColor(Color.blue);
           
        }
            if (color == 6) {
                r.setColor(INDIGO);   
                g.setColor(INDIGO);
                g1.setColor(INDIGO);   
                g2.setColor(INDIGO);
                g3.setColor(INDIGO);   
                g4.setColor(INDIGO);
                g5.setColor(INDIGO);   
                g6.setColor(INDIGO);
                g7.setColor(INDIGO);   
                g8.setColor(INDIGO);
                g9.setColor(INDIGO);   
                g10.setColor(INDIGO);
      
        } 
            if (color == 7) {
                r.setColor(VIOLET); 
                g.setColor(VIOLET);
                g1.setColor(VIOLET); 
                g2.setColor(VIOLET);
                g3.setColor(VIOLET); 
                g4.setColor(VIOLET);
                g5.setColor(VIOLET); 
                g6.setColor(VIOLET);
                g7.setColor(VIOLET); 
                g8.setColor(VIOLET);
                g9.setColor(VIOLET); 
                g10.setColor(VIOLET);
          
        }
            if (color == 8) {
                r.setColor(Color.pink);
	            g.setColor(Color.pink);
                g1.setColor(Color.pink);
	            g2.setColor(Color.pink);
                g3.setColor(Color.pink);
	            g4.setColor(Color.pink);
                g5.setColor(Color.pink);
	            g6.setColor(Color.pink);
                g7.setColor(Color.pink);
	            g8.setColor(Color.pink);
                g9.setColor(Color.pink);
	            g10.setColor(Color.pink);
           
        } 
            if (color == 9) {
                r.setColor(Color.white);
                g.setColor(Color.white);
                g1.setColor(Color.white);
                g2.setColor(Color.white);
                g3.setColor(Color.white);
                g4.setColor(Color.white);
                g5.setColor(Color.white);
                g6.setColor(Color.white);
                g7.setColor(Color.white);
                g8.setColor(Color.white);
                g9.setColor(Color.white);
                g10.setColor(Color.white);            
      
        }
            if (color == 10) {
                r.setColor(Color.black);
                g.setColor(Color.black);
                g1.setColor(Color.black);
                g2.setColor(Color.black);
                g3.setColor(Color.black);
                g4.setColor(Color.black);
                g5.setColor(Color.black);
                g6.setColor(Color.black);
                g7.setColor(Color.black);
                g8.setColor(Color.black);
                g9.setColor(Color.black);
                g10.setColor(Color.black);
           
        }
            
            //-----------------------------선 두께 설정----------------------//
            if(thick==1)
            {	
            	L.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            }
            if(thick==2)
            {
            	L.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            }
            if(thick==3)
            {
            	
            	L.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            }
            if(thick==4)
            {
            	L.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            }
            
            //----------------------- 기능 실행 ---------------------------------//
            // 처음 상태에서 버퍼이미지에 해당 배경색의 사각형을 그리기(처음에 버퍼이미지 마다 배경색을 정해줌)
            if(select==-1)
            {
            	
            	switch(back) {
            	case 0:
            		r.setColor(Color.white);
            		r.fillRect(0, 0, 1000, 1000);
            		break;
				case 1:
					r.setColor(Color.red);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 2:
					r.setColor(Color.orange);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 3:
					r.setColor(Color.yellow);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 4:
					r.setColor(Color.green);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 5:
					r.setColor(Color.blue);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 6:
					r.setColor(INDIGO);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 7:
					r.setColor(VIOLET);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 8:
					r.setColor(Color.pink);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 9:
					r.setColor(Color.white);
					r.fillRect(0, 0, 1000, 1000);
					break;
				case 10:
					r.setColor(Color.black);
					r.fillRect(0, 0, 1000, 1000);
					break;
            	}
				g.setColor(Color.white);
				g.fillRect(0, 0, 1000, 1000);
				g1.setColor(Color.red);
				g1.fillRect(0, 0, 1000, 1000);
				g2.setColor(Color.orange);
				g2.fillRect(0, 0, 1000, 1000);
				g3.setColor(Color.yellow);
				g3.fillRect(0, 0, 1000, 1000);
				g4.setColor(Color.green);
				g4.fillRect(0, 0, 1000, 1000);
				g5.setColor(Color.blue);
				g5.fillRect(0, 0, 1000, 1000);
				g6.setColor(INDIGO);
				g6.fillRect(0, 0, 1000, 1000);
				g7.setColor(VIOLET);
				g7.fillRect(0, 0, 1000, 1000);
				g8.setColor(Color.pink);
				g8.fillRect(0, 0, 1000, 1000);
				g9.setColor(Color.white);
				g9.fillRect(0, 0, 1000, 1000);
				g10.setColor(Color.black);
				g10.fillRect(0, 0, 1000, 1000);
				
            }
  
			//원----------------------------------------------------------------------------
            else if(select == 1){
				int num = points.size();
		    	if(num < 2) return;
		    	
		    	p1 = (Point)points.firstElement();
		    	p2 = (Point)points.lastElement();
		    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
		    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
		      	r.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);

			}
            
			//삼각형---------------------------------------------------------------------------
            else if(select == 2){
				int num = points.size();
		    	if(num < 2) return;
		    	int x1,x2,y1,y2;
		       	int xPoints[] = new int[3];
		    	int yPoints[] = new int[3];
		    	p1 = (Point)points.firstElement();
		    	p2 = (Point)points.lastElement();
		    	
		       	x1 = Integer.min(p1.getX(), p2.getX());
		    	x2 = Integer.max(p1.getX(), p2.getX());
		    	y1 = Integer.min(p1.getY(), p2.getY());
		    	y2 = Integer.max(p1.getY(), p2.getY());
		    	
		    	xPoints[0] = x1;
		    	xPoints[1] = (x1+x2)/2;
		    	xPoints[2] = x2;

		    	yPoints[0] = y2;
		    	yPoints[1] = y1;
		    	yPoints[2] = y2;

		       	r.drawPolygon(xPoints, yPoints, 3);
			}
			//사각형---------------------------------------------------------------------------
            else if(select == 3){
				int num = points.size();
		    	if(num < 2) return;

		    	p1 = (Point)points.firstElement();
		    	p2 = (Point)points.lastElement();
		    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
		    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
		      	r.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
			}
			//둥근 사각형--------------------------------------------------------------------------
            else if(select == 4){
				int num = points.size();
		    	if(num < 2) return;

		    	p1 = (Point)points.firstElement();
		    	p2 = (Point)points.lastElement();
		    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
		    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
		      	r.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
			}
			//오각형------------------------------------------------------------------------------
            else if(select == 5){
				int num = points.size();
		    	if(num < 2) return;
		    	int x1, x2, y1, y2;
		    	int xPoints[] = new int[5];
		    	int yPoints[] = new int[5];
		    	p1 = (Point)points.firstElement();
		    	p2 = (Point)points.lastElement();
		    	
		    	x1 = Integer.min(p1.getX(), p2.getX());
		    	x2 = Integer.max(p1.getX(), p2.getX());
		    	y1 = Integer.min(p1.getY(), p2.getY());
		    	y2 = Integer.max(p1.getY(), p2.getY());
		    	
		    	xPoints[0] = (x1 + x2)/2;
		    	xPoints[1] = x1;
		    	xPoints[2] = (3*x1+x2)/4;
		    	xPoints[3] = (x1+3*x2)/4;
		    	xPoints[4] = x2;

		    	yPoints[0] = y1;
		    	yPoints[1] = (y1+y2)/2;
		    	yPoints[2] = y2;
		    	yPoints[3] = y2;
		    	yPoints[4] = (y1+y2)/2;
		    	
		    	r.drawPolygon(xPoints, yPoints, 5);
		    }
			//선-----------------------------------------------------------------------------
            else if(select ==6 ){
				int num = points.size();
		    	if(num < 2) return;

		    	p1 = (Point)points.firstElement();
		    	p2 = (Point)points.lastElement();
		      	r.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			}
			//자율곡선---------------------------------------------------------------------------
            else if(select == 7){
			    
		    	int num = points.size();
		    	if(num < 2) return;

		    	p1 = (Point)points.firstElement();
		    	for(int j = 1; j < num; j++) {
		    		p2 = (Point)points.elementAt(j);
		      		r.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g1.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g2.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g3.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g4.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g5.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g6.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g7.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g8.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g9.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			      	g10.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		      		p1 = p2;
		    	}
			}
			//글상자------------------------------------------------------------------------
            else if(select == 8){
			    
				if(Text == null){
					Text = JOptionPane.showInputDialog("글자를 입력해주세요 : ");
					
					repaint();
				}			
		    }
			
			//불러오기------------------------------------------------------------------------- 
            else if(select==9){
				img = Toolkit.getDefaultToolkit().getImage(file);
				r.drawImage(img, 0, 0, null);
			}
			//저장----------------------------------------------------------------------------
            else if(select==10){
				img = Toolkit.getDefaultToolkit().getImage(file);
				try{
					switch(back) {
						case 0 :
							 ImageIO.write(x, "jpg", new File(file));
							 break;
						case 1 :
							 ImageIO.write(C1, "jpg", new File(file));
							 break;
						case 2 :
							 ImageIO.write(C2, "jpg", new File(file));
							 break;
						case 3 :
							 ImageIO.write(C3, "jpg", new File(file));
							 break;
						case 4 :
							 ImageIO.write(C4, "jpg", new File(file));
							 break;
						case 5 :
							 ImageIO.write(C5, "jpg", new File(file));
							 break;
						case 6 :
							 ImageIO.write(C6, "jpg", new File(file));
							 break;
						case 7 :
							 ImageIO.write(C7, "jpg", new File(file));
							 break;
						case 8 :
							 ImageIO.write(C8, "jpg", new File(file));
							 break;
						case 9 :
							 ImageIO.write(C9, "jpg", new File(file));
							 break;
						case 10 :
							 ImageIO.write(C10, "jpg", new File(file));
							 break;
					}
				} catch(Exception e){
					e.getStackTrace();
				}
			}
			//지우개------------------------------------------------------------------------
            else if(select==12)
			{	//배경색에 맞추어 지우개 색 재정의
				
            	if(back == 0){
					
					r.setColor(Color.white);
				}
				if(back == 1){
					r.setColor(Color.red);
				}
				if(back == 2){
					r.setColor(Color.orange);
				}
				if(back == 3){
					r.setColor(Color.yellow);
				}
				if(back == 4){
					r.setColor(Color.green);
				}
				if(back == 5){
					r.setColor(Color.blue);
				}
				if(back == 6){
					r.setColor(INDIGO);
				}
				if(back == 7){
					r.setColor(VIOLET);
				}
				if(back == 8){
					r.setColor(Color.pink);
				}
				if(back == 9){
					r.setColor(Color.white);
				}
				if(back == 10){
					r.setColor(Color.black);
				}
				g.setColor(Color.white);
				g1.setColor(Color.red);
				g2.setColor(Color.orange);
				g3.setColor(Color.yellow);
				g4.setColor(Color.green);
				g5.setColor(Color.blue);
				g6.setColor(INDIGO);
				g7.setColor(VIOLET);
				g8.setColor(Color.pink);
				g9.setColor(Color.white);
				g10.setColor(Color.black);
				
				
				int num = points.size();
		    	if(num < 2) return;

		    	p1 = (Point)points.firstElement();
		    	for(int j = 1; j < num; j++) {
		    		p2 = (Point)points.elementAt(j);
		      		r.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g1.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g2.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g3.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g4.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g5.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g6.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g7.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g8.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g9.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		g10.fillRect(p1.getX(), p1.getY(), eraseSize, eraseSize);
		      		p1 = p2;
		    	}
			}
			
			
            //채우기--------------------------------------------------------------------------
            else if(select==15)
            {
            	a:for(i=num-1;i>=0;i--)
            	{	
            		//밑의 switch문에서 fill~함수를 사용해 채우기를 실행하기 전 색을 설정.
            		//sv파일에는 그린 도형에 대한 정보가 저장되어 있다. 이 정보를 불러와서 색을 재정의 해준다.
            		//재정의 한 색은 아래의 switch문에서 fill~함수를 사용해 채워진 도형을 그리는데 사용된다.
            		if(sv[i].color==0)
            		{
            			r.setColor(Color.black);
						g.setColor(Color.black);
						g1.setColor(Color.black);
						g2.setColor(Color.black);
						g3.setColor(Color.black);
						g4.setColor(Color.black);
						g5.setColor(Color.black);
						g6.setColor(Color.black);
						g7.setColor(Color.black);
						g8.setColor(Color.black);
						g9.setColor(Color.black);
						g10.setColor(Color.black);
            		}
            		
            		if(sv[i].color==1)
            		{
            			r.setColor(Color.red);
						g.setColor(Color.red);
						g1.setColor(Color.red);
						g2.setColor(Color.red);
						g3.setColor(Color.red);
						g4.setColor(Color.red);
						g5.setColor(Color.red);
						g6.setColor(Color.red);
						g7.setColor(Color.red);
						g8.setColor(Color.red);
						g9.setColor(Color.red);
						g10.setColor(Color.red);
            		}
            		
            		if(sv[i].color==2)
            		{
            			r.setColor(Color.orange);
						g.setColor(Color.orange);
						g1.setColor(Color.orange);
						g2.setColor(Color.orange);
						g3.setColor(Color.orange);
						g4.setColor(Color.orange);
						g5.setColor(Color.orange);
						g6.setColor(Color.orange);
						g7.setColor(Color.orange);
						g8.setColor(Color.orange);
						g9.setColor(Color.orange);
						g10.setColor(Color.orange);
            		}
            		
            		if(sv[i].color==3)
            		{
            			r.setColor(Color.yellow);
						g.setColor(Color.yellow);
						g1.setColor(Color.yellow);
						g2.setColor(Color.yellow);
						g3.setColor(Color.yellow);
						g4.setColor(Color.yellow);
						g5.setColor(Color.yellow);
						g6.setColor(Color.yellow);
						g7.setColor(Color.yellow);
						g8.setColor(Color.yellow);
						g9.setColor(Color.yellow);
						g10.setColor(Color.yellow);
            		}
            		
            		if(sv[i].color==4)
            		{
            			r.setColor(Color.green);
						g.setColor(Color.green);
						g1.setColor(Color.green);
						g2.setColor(Color.green);
						g3.setColor(Color.green);
						g4.setColor(Color.green);
						g5.setColor(Color.green);
						g6.setColor(Color.green);
						g7.setColor(Color.green);
						g8.setColor(Color.green);
						g9.setColor(Color.green);
						g10.setColor(Color.green);
            		}
            		
            		if(sv[i].color==5)
            		{
            			r.setColor(Color.blue);
						g.setColor(Color.blue);
						g1.setColor(Color.blue);
						g2.setColor(Color.blue);
						g3.setColor(Color.blue);
						g4.setColor(Color.blue);
						g5.setColor(Color.blue);
						g6.setColor(Color.blue);
						g7.setColor(Color.blue);
						g8.setColor(Color.blue);
						g9.setColor(Color.blue);
						g10.setColor(Color.blue);
            		}
            		
            		if(sv[i].color==6)
            		{
            			r.setColor(INDIGO);
						g.setColor(INDIGO);
						g1.setColor(INDIGO);
						g2.setColor(INDIGO);
						g3.setColor(INDIGO);
						g4.setColor(INDIGO);
						g5.setColor(INDIGO);
						g6.setColor(INDIGO);
						g7.setColor(INDIGO);
						g8.setColor(INDIGO);
						g9.setColor(INDIGO);
						g10.setColor(INDIGO);
            		}
            		
            		if(sv[i].color==7)
            		{
            			r.setColor(VIOLET);
						g.setColor(VIOLET);
						g1.setColor(VIOLET);
						g2.setColor(VIOLET);
						g3.setColor(VIOLET);
						g4.setColor(VIOLET);
						g5.setColor(VIOLET);
						g6.setColor(VIOLET);
						g7.setColor(VIOLET);
						g8.setColor(VIOLET);
						g9.setColor(VIOLET);
						g10.setColor(VIOLET);
            		}
            		
            		if(sv[i].color==8)
            		{
            			r.setColor(Color.pink);
						g.setColor(Color.pink);
						g1.setColor(Color.pink);
						g2.setColor(Color.pink);
						g3.setColor(Color.pink);
						g4.setColor(Color.pink);
						g5.setColor(Color.pink);
						g6.setColor(Color.pink);
						g7.setColor(Color.pink);
						g8.setColor(Color.pink);
						g9.setColor(Color.pink);
						g10.setColor(Color.pink);
            		}
            		
            		if(sv[i].color==9)
            		{
            			r.setColor(Color.white);
						g.setColor(Color.white);
						g1.setColor(Color.white);
						g2.setColor(Color.white);
						g3.setColor(Color.white);
						g4.setColor(Color.white);
						g5.setColor(Color.white);
						g6.setColor(Color.white);
						g7.setColor(Color.white);
						g8.setColor(Color.white);
						g9.setColor(Color.white);
						g10.setColor(Color.white);
            		}
            		
            		if(sv[i].color==10)
            		{
            			r.setColor(Color.black);
						g.setColor(Color.black);
						g1.setColor(Color.black);
						g2.setColor(Color.black);
						g3.setColor(Color.black);
						g4.setColor(Color.black);
						g5.setColor(Color.black);
						g6.setColor(Color.black);
						g7.setColor(Color.black);
						g8.setColor(Color.black);
						g9.setColor(Color.black);
						g10.setColor(Color.black);
            		}
            		
            		// 도형의 채우기 실행
            		switch(sv[i].select)
            		{
            			//원
            			case 1:
            			{
            				p1 = (Point)sv[i].points.firstElement();
    				    	p2 = (Point)sv[i].points.lastElement();
    				    	Point p3 = (Point)points.lastElement();
    				    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
    				    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
    				      	if(Integer.min(p1.getX(), p2.getX())<p3.getX() && Integer.max(p1.getX(), p2.getX())>p3.getX() && Integer.min(p1.getY(), p2.getY())<p3.getY() && Integer.max(p1.getY(), p2.getY())>p3.getY()){
    				      		r.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g1.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g2.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g3.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g4.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g5.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g6.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g7.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g8.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g9.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g10.fillOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		
    				      		break a;
            			}
            		}break;
            			//삼각형
            			case 2:{
            				int x1,x2,y1,y2;
            		       	int xPoints[] = new int[3];
            		    	int yPoints[] = new int[3];
            		    	p1 = (Point)sv[i].points.firstElement();
    						p2 = (Point)sv[i].points.lastElement();
    				    	Point p3 = (Point)points.lastElement();
            		    	   
            		       	x1 = Integer.min(p1.getX(), p2.getX());
            		    	x2 = Integer.max(p1.getX(), p2.getX());
            		    	y1 = Integer.min(p1.getY(), p2.getY());
            		    	y2 = Integer.max(p1.getY(), p2.getY());
            		    	if(x1<p3.getX() && x2>p3.getX() && y1<p3.getY() && y2>p3.getY()){
            		    	xPoints[0] = x1;
            		    	xPoints[1] = (x1+x2)/2;
            		    	xPoints[2] = x2;

            		    	yPoints[0] = y2;
            		    	yPoints[1] = y1;
            		    	yPoints[2] = y2;
    			    	
    							r.fillPolygon(xPoints, yPoints, 3);
    							g.fillPolygon(xPoints, yPoints, 3);
    							g1.fillPolygon(xPoints, yPoints, 3);
    							g2.fillPolygon(xPoints, yPoints, 3);
    							g3.fillPolygon(xPoints, yPoints, 3);
    							g4.fillPolygon(xPoints, yPoints, 3);
    							g5.fillPolygon(xPoints, yPoints, 3);
    							g6.fillPolygon(xPoints, yPoints, 3);
    							g7.fillPolygon(xPoints, yPoints, 3);
    							g8.fillPolygon(xPoints, yPoints, 3);
    							g9.fillPolygon(xPoints, yPoints, 3);
    							g10.fillPolygon(xPoints, yPoints, 3);
    							break a;
    						}
            			}break;
            			//사각형
            			case 3:{
    						p1 = (Point)sv[i].points.firstElement();
    				    	p2 = (Point)sv[i].points.lastElement();
    				    	Point p3 = (Point)points.lastElement();
    				    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
    				    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
    				      	if(Integer.min(p1.getX(), p2.getX())<p3.getX() && Integer.max(p1.getX(), p2.getX())>p3.getX() && Integer.min(p1.getY(), p2.getY())<p3.getY() && Integer.max(p1.getY(), p2.getY())>p3.getY()){
    				      		r.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g1.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g2.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g3.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g4.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g5.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g6.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g7.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g8.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g9.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		g10.fillRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    				      		break a;
    				      	}
    					} break;
    					//둥근 사각형
            			case 4:{
    						p1 = (Point)sv[i].points.firstElement();
    				    	p2 = (Point)sv[i].points.lastElement();
    				    	Point p3 = (Point)points.lastElement();
    				    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
    				    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
    				      	if(Integer.min(p1.getX(), p2.getX())<p3.getX() && Integer.max(p1.getX(), p2.getX())>p3.getX() && Integer.min(p1.getY(), p2.getY())<p3.getY() && Integer.max(p1.getY(), p2.getY())>p3.getY()){
    				      		r.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g1.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g2.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g3.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g4.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g5.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g6.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g7.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g8.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g9.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		g10.fillRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
    				      		break a;
    				      	}
    					} break;
    					//오각형
            			case 5:{
    						int x1, x2, y1, y2;
    						int xPoints[] = new int[5];
    						int yPoints[] = new int[5];
    						p1 = (Point)sv[i].points.firstElement();
    						p2 = (Point)sv[i].points.lastElement();
    				    	Point p3 = (Point)points.lastElement();
    			    	
    						x1 = Integer.min(p1.getX(), p2.getX());
    						x2 = Integer.max(p1.getX(), p2.getX());
    						y1 = Integer.min(p1.getY(), p2.getY());
    						y2 = Integer.max(p1.getY(), p2.getY());
    						if(x1<p3.getX() && x2>p3.getX() && y1<p3.getY() && y2>p3.getY()){
    							xPoints[0] = (x1 + x2)/2;
    							xPoints[1] = x1;
    							xPoints[2] = (3*x1+x2)/4;
    							xPoints[3] = (x1+3*x2)/4;
    							xPoints[4] = x2;

    							yPoints[0] = y1;
    							yPoints[1] = (y1+y2)/2;
    							yPoints[2] = y2;
    							yPoints[3] = y2;
    							yPoints[4] = (y1+y2)/2;
    			    	
    							r.fillPolygon(xPoints, yPoints, 5);
    							g.fillPolygon(xPoints, yPoints, 5);
    							g1.fillPolygon(xPoints, yPoints, 5);
    							g2.fillPolygon(xPoints, yPoints, 5);
    							g3.fillPolygon(xPoints, yPoints, 5);
    							g4.fillPolygon(xPoints, yPoints, 5);
    							g5.fillPolygon(xPoints, yPoints, 5);
    							g6.fillPolygon(xPoints, yPoints, 5);
    							g7.fillPolygon(xPoints, yPoints, 5);
    							g8.fillPolygon(xPoints, yPoints, 5);
    							g9.fillPolygon(xPoints, yPoints, 5);
    							g10.fillPolygon(xPoints, yPoints, 5);
    							break a;
    						}
    					} break;
            	}
            	}
            		repaint();
            }
			
            //모두 지우기 ---------------------------------------------------------------------
            //배경과 같은 색을 가진 전체 그리기 화면 사이즈와 같은 크기의 사각형을 그린다.
            else if(select==16){										
				if(back == 0){
					r.setColor(Color.white);
					r.fillRect(0, 0, 1000, 1000);
					g.setColor(Color.white);
					g.fillRect(0, 0, 1000, 1000);
				}
				if(back == 1){
					r.setColor(Color.red);
					r.fillRect(0, 0, 1000, 1000);
					g1.setColor(Color.red);
					g1.fillRect(0, 0, 1000, 1000);
				}
				if(back == 2){
					r.setColor(Color.orange);
					r.fillRect(0, 0, 1000, 1000);
					g2.setColor(Color.orange);
					g2.fillRect(0, 0, 1000, 1000);
				}
				if(back == 3){
					r.setColor(Color.yellow);
					r.fillRect(0, 0, 1000, 1000);
					g3.setColor(Color.yellow);
					g3.fillRect(0, 0, 1000, 1000);
				}
				if(back == 4){
					r.setColor(Color.green);
					r.fillRect(0, 0, 1000, 1000);
					g4.setColor(Color.green);
					g4.fillRect(0, 0, 1000, 1000);
				}
				if(back == 5){
					r.setColor(Color.blue);
					r.fillRect(0, 0, 1000, 1000);
					g5.setColor(Color.blue);
					g5.fillRect(0, 0, 1000, 1000);
				}
				if(back == 6){
					r.setColor(INDIGO);
					r.fillRect(0, 0, 1000, 1000);
					g6.setColor(INDIGO);
					g6.fillRect(0, 0, 1000, 1000);
				}
				if(back == 7){
					r.setColor(VIOLET);
					r.fillRect(0, 0, 1000, 1000);
					g7.setColor(VIOLET);
					g7.fillRect(0, 0, 1000, 1000);
				}
				if(back == 8){
					r.setColor(Color.pink);
					r.fillRect(0, 0, 1000, 1000);
					g8.setColor(Color.pink);
					g8.fillRect(0, 0, 1000, 1000);
				}
				if(back == 9){
					r.setColor(Color.white);
					r.fillRect(0, 0, 1000, 1000);
					g9.setColor(Color.white);
					g9.fillRect(0, 0, 1000, 1000);
				}
				if(back == 10){
					r.setColor(Color.black);
					r.fillRect(0, 0, 1000, 1000);
					g10.setColor(Color.black);
					g10.fillRect(0, 0, 1000, 1000);
				}

				num = 0;
				points = new Vector();
				repaint();
			}
            //왼쪽 회전-----------------------------------------------------------------------       
            else if(select==21)
            {
				/**choose기능을 사용해 마우스로 원하는 영역을 선택한다.
				/*선택한 영역의 좌표 값을 얻어서 해당 영역의 길이와 높이를 구한다.
				 *구한 길이와 높이를 갖는 직사각형 영역 만큼의 정보를 갖는 새로운 버퍼 rotate와 rotate2를 생성한다.
				 */
        		Graphics H = hid.getGraphics();
				H.drawImage(x, 0, 0, null);
				
				p1 =  (Point) points2.firstElement();
				p2 =  (Point) points2.lastElement();
				
				int x1 = Integer.min(p1.getX(), p2.getX());
				int x2 = Integer.max(p1.getX(), p2.getX());
				int y1 = Integer.min(p1.getY(), p2.getY());
				int y2 = Integer.max(p1.getY(), p2.getY());
				
				p1 = new Point(x1, y1);
				p2 = new Point(x2, y2);
				
				width = p2.getX()-p1.getX();
				height = p2.getY()-p1.getY();

				rotate = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
				rotate2 = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
				
				/**
				 * setRGB를 통해 각각의 픽셀 값을 받아온 후 두 개의 for문을 사용해 x,y 좌표의 위치를 바꾸었다.
				 * 바꾼 후 해당 정보를 rotate2버퍼에 적용시킨다.
				 * rotate는 도형의 회전에 관여, rotate2는 도형의 색이 변하지 않도록 하는데 관여한다.
				 */
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						rotate.setRGB(j, width - i - 1, x.getRGB(p1.getX() + i, p1.getY() + j));
					}
				}
				for (i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						rotate2.setRGB(j, i, rotate.getRGB(j, i));
					}
				}
				//현재 배경색에 대한 정보를 얻는다.
				if(back == 0){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
			
				if(back == 1){
					g1.setColor(Color.red);
					r.setColor(Color.red);
					H.setColor(Color.red);
				}
				if(back == 2){
					g2.setColor(Color.orange);
					r.setColor(Color.orange);
					H.setColor(Color.orange);
				}
				if(back == 3){
					g3.setColor(Color.yellow);
					r.setColor(Color.yellow);
					H.setColor(Color.yellow);
				}
				if(back == 4){
					g4.setColor(Color.green);
					r.setColor(Color.green);
					H.setColor(Color.green);
				}
				if(back == 5){
					g5.setColor(Color.blue);
					r.setColor(Color.blue);
					H.setColor(Color.blue);
				}
				if(back == 6){
					g6.setColor(INDIGO);
					r.setColor(INDIGO);
					H.setColor(INDIGO);
				}
				if(back == 7){
					g7.setColor(VIOLET);
					r.setColor(VIOLET);
					H.setColor(VIOLET);
				}
				if(back == 8){
					g8.setColor(Color.pink);
					r.setColor(Color.pink);
					H.setColor(Color.pink);
				}
				if(back == 9){
					g9.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 10){
					g10.setColor(Color.black);
					r.setColor(Color.black);
					H.setColor(Color.black);
				}
				
				g.fillRect(p1.getX(), p1.getY(), width, height);
				g.drawImage(rotate, p1.getX(), p1.getY(), null);
				r.fillRect(p1.getX(), p1.getY(), width, height);
				r.drawImage(rotate, p1.getX(), p1.getY(), null);
				H.fillRect(p1.getX(), p1.getY(), width, height);
				H.drawImage(rotate, p1.getX(), p1.getY(), null);		
				
				//rotate2의 색을 설정한다.
				//회전한 후의 결과를 drawImage를 통해 보여준다.
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.red.getRGB());
						}
					}
				}
				g1.fillRect(p1.getX(), p1.getY(), width, height);
				g1.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.orange.getRGB());
						}
					}
				}	
				g2.fillRect(p1.getX(), p1.getY(), width, height);
				g2.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.yellow.getRGB());
						}
					}
				}
				g3.fillRect(p1.getX(), p1.getY(), width, height);
				g3.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.green.getRGB());
						}
					}
				}		
				g4.fillRect(p1.getX(), p1.getY(), width, height);
				g4.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.blue.getRGB());
						}
					}
				}
				g5.fillRect(p1.getX(), p1.getY(), width, height);
				g5.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, INDIGO.getRGB());
						}
					}
				}
				g6.fillRect(p1.getX(), p1.getY(), width, height);
				g6.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, VIOLET.getRGB());
						}
					}
				}
				g7.fillRect(p1.getX(), p1.getY(), width, height);
				g7.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, VIOLET.getRGB());
						}
					}
				}
				g7.fillRect(p1.getX(), p1.getY(), width, height);
				g7.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.pink.getRGB());
						}
					}
				}
				g8.fillRect(p1.getX(), p1.getY(), width, height);
				g8.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.white.getRGB());
						}
					}
				}
				g9.fillRect(p1.getX(), p1.getY(), width, height);
				g9.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.black.getRGB());
						}
					}
				}
				g10.fillRect(p1.getX(), p1.getY(), width, height);
				g10.drawImage(rotate2, p1.getX(), p1.getY(), null);
				p2 = new Point(x1+height, y1+width);
				
				points2.add(0, p1);
				points2.add(p2);
				select = 20;
				
				H.setColor(Color.gray);
		      	H.drawRect(p1.getX(), p1.getY(), height, width);
		      	
				repaint();
            }
            //오른쪽 회전---------------------------------------------------------------------------
            else if(select==22)
            {	/**choose기능을 사용해 마우스로 원하는 영역을 선택한다.
				/*선택한 영역의 좌표 값을 얻어서 해당 영역의 길이와 높이를 구한다.
				 *구한 길이와 높이를 갖는 직사각형 영역 만큼의 정보를 갖는 새로운 버퍼 rotate와 rotate2를 생성한다.
				 */
        		Graphics H = hid.getGraphics();
				H.drawImage(x, 0, 0, null);
				
				p1 =  (Point) points2.firstElement();
				p2 =  (Point) points2.lastElement();
				
				int x1 = Integer.min(p1.getX(), p2.getX());
				int x2 = Integer.max(p1.getX(), p2.getX());
				int y1 = Integer.min(p1.getY(), p2.getY());
				int y2 = Integer.max(p1.getY(), p2.getY());
				
				p1 = new Point(x1, y1);
				p2 = new Point(x2, y2);
				
				width = p2.getX()-p1.getX();
				height = p2.getY()-p1.getY();
				rotate = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
				rotate2 = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
				
				/**
				 * setRGB를 통해 각각의 픽셀 값을 받아온 후 두 개의 for문을 사용해 x,y 좌표의 위치를 바꾸었다.
				 * 바꾼 후 해당 정보를 rotate2버퍼에 적용시킨다.
				 * rotate는 도형의 회전에 관여, rotate2는 도형의 색이 변하지 않도록 하는데 관여한다.
				 */
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						rotate.setRGB(height - j - 1, i, x.getRGB(p1.getX() + i, p1.getY() + j));
					}
				}
				for (i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						rotate2.setRGB(j, i, rotate.getRGB(j, i));
					}
				}
				//현재 배경색에 대한 정보를 얻는다.
				if(back == 0){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 1){
					g.setColor(Color.red);
					r.setColor(Color.red);
					H.setColor(Color.red);
				}
				if(back == 2){
					g.setColor(Color.orange);
					r.setColor(Color.orange);
					H.setColor(Color.orange);
				}
				if(back == 3){
					g.setColor(Color.yellow);
					r.setColor(Color.yellow);
					H.setColor(Color.yellow);
				}
				if(back == 4){
					g.setColor(Color.green);
					r.setColor(Color.green);
					H.setColor(Color.green);
				}
				if(back == 5){
					g.setColor(Color.blue);
					r.setColor(Color.blue);
					H.setColor(Color.blue);
				}
				if(back == 6){
					g.setColor(INDIGO);
					r.setColor(INDIGO);
					H.setColor(INDIGO);
				}
				if(back == 7){
					g.setColor(VIOLET);
					r.setColor(VIOLET);
					H.setColor(VIOLET);
				}
				if(back == 8){
					g.setColor(Color.pink);
					r.setColor(Color.pink);
					H.setColor(Color.pink);
				}
				if(back == 9){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 10){
					g.setColor(Color.black);
					r.setColor(Color.black);
					H.setColor(Color.black);
				}

				g.fillRect(p1.getX(), p1.getY(), width, height);
				g.drawImage(rotate, p1.getX(), p1.getY(), null);
				r.fillRect(p1.getX(), p1.getY(), width, height);
				r.drawImage(rotate, p1.getX(), p1.getY(), null);
				H.fillRect(p1.getX(), p1.getY(), width, height);
				H.drawImage(rotate, p1.getX(), p1.getY(), null);		
				
				//rotate2의 색을 설정한다.
				//회전한 후의 결과를 drawImage를 통해 보여준다.
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.red.getRGB());
						}
					}
				}
				g1.fillRect(p1.getX(), p1.getY(), width, height);
				g1.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.orange.getRGB());
						}
					}
				}	
				g2.fillRect(p1.getX(), p1.getY(), width, height);
				g2.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.yellow.getRGB());
						}
					}
				}
				g3.fillRect(p1.getX(), p1.getY(), width, height);
				g3.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.green.getRGB());
						}
					}
				}		
				g4.fillRect(p1.getX(), p1.getY(), width, height);
				g4.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.blue.getRGB());
						}
					}
				}
				g5.fillRect(p1.getX(), p1.getY(), width, height);
				g5.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, INDIGO.getRGB());
						}
					}
				}
				g6.fillRect(p1.getX(), p1.getY(), width, height);
				g6.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, VIOLET.getRGB());
						}
					}
				}
				g7.fillRect(p1.getX(), p1.getY(), width, height);
				g7.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, VIOLET.getRGB());
						}
					}
				}
				g7.fillRect(p1.getX(), p1.getY(), width, height);
				g7.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.pink.getRGB());
						}
					}
				}
				g8.fillRect(p1.getX(), p1.getY(), width, height);
				g8.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.white.getRGB());
						}
					}
				}
				g9.fillRect(p1.getX(), p1.getY(), width, height);
				g9.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<height;i++){
					for(int j=0;j<width;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.black.getRGB());
						}
					}
				}
				g10.fillRect(p1.getX(), p1.getY(), width, height);
				g10.drawImage(rotate2, p1.getX(), p1.getY(), null);
				p2 = new Point(x1+height, y1+width);
				
				points2.add(0, p1);
				points2.add(p2);
				select = 20;
				
				H.setColor(Color.gray);
		      	H.drawRect(p1.getX(), p1.getY(), height, width);
		      	
				repaint();
            }            
            //선택-------------------------------------------------------------------------------
            if(select==20)
            {
            	
				Graphics H = hid.getGraphics();

    			//현재 배경색에 맞는 버퍼 선택
				switch(back) {
							
				case 0: 
					H.drawImage(this.x, 0, 0, null);
					break;
				case 1: 
					H.drawImage(C1, 0, 0, null);
					break;
				case 2: 
					H.drawImage(C2, 0, 0, null);
					break;
				case 3: 
					H.drawImage(C3, 0, 0, null);
					break;
				case 4: 
					H.drawImage(C4, 0, 0, null);
					break;
				case 5: 
					H.drawImage(C5, 0, 0, null);
					break;
				case 6: 
					H.drawImage(C6, 0, 0, null);
					break;
				case 7: 
					H.drawImage(C7, 0, 0, null);
					break;
				case 8: 
					H.drawImage(C8, 0, 0, null);
					break;
				case 9: 
					H.drawImage(C9, 0, 0, null);
					break;
				case 10: 
					H.drawImage(C10, 0, 0, null);
					break;
				}
            	
            	r.drawImage(hid, 0, 0, null);

		    	p1 = (Point) points.firstElement();
		    	p2 = (Point) points.lastElement();
		    	width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
		    	height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
		    	
		    	//선택하고자 하는 영역을 직사각형으로 그려지도록한다.
		    	//그려진 직사각형은 마우스로 드래그 하는 동안에만 보여지고 마우스를 떼면 사라진다.
		      	r.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
	
            }
            
            //상하대칭-------------------------------------------------------------------------
            if(select == 23){
            	
            	/**choose기능을 사용해 마우스로 원하는 영역을 선택한다.
				/*선택한 영역의 좌표 값을 얻어서 해당 영역의 길이와 높이를 구한다.
				 *구한 길이와 높이를 갖는 직사각형 영역 만큼의 정보를 갖는 새로운 버퍼 rotate와 rotate2를 생성한다.
				 */
				Graphics H = hid.getGraphics();
				H.drawImage(x, 0, 0, null);
				
				p1 =  (Point)points2.firstElement();
				p2 =  (Point)points2.lastElement();
				
				int x1 = Integer.min(p1.getX(), p2.getX());
				int x2 = Integer.max(p1.getX(), p2.getX());
				int y1 = Integer.min(p1.getY(), p2.getY());
				int y2 = Integer.max(p1.getY(), p2.getY());
				
				p1 = new Point(x1, y1);
				p2 = new Point(x2, y2);
				
				width = p2.getX()-p1.getX();
				height = p2.getY()-p1.getY();
				rotate = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				rotate2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				/**
				 * setRGB를 통해 각각의 픽셀 값을 받아온 후 두 개의 for문을 사용해 x,y 좌표의 위치를 바꾸었다.
				 * 바꾼 후 해당 정보를 rotate2버퍼에 적용시킨다.
				 * rotate는 도형의 대칭에 관여, rotate2는 도형의 색이 변하지 않도록 하는데 관여한다.
				 */
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						rotate.setRGB(i, height - j - 1, x.getRGB(p1.getX() + i, p1.getY() + j));
					}
				}
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						rotate2.setRGB(i, j, rotate.getRGB(i, j));
					}
				}
				//현재 배경색에 대한 정보를 얻는다.
				if(back == 0){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 1){
					g.setColor(Color.red);
					r.setColor(Color.red);
					H.setColor(Color.red);
				}
				if(back == 2){
					g.setColor(Color.orange);
					r.setColor(Color.orange);
					H.setColor(Color.orange);
				}
				if(back == 3){
					g.setColor(Color.yellow);
					r.setColor(Color.yellow);
					H.setColor(Color.yellow);
				}
				if(back == 4){
					g.setColor(Color.green);
					r.setColor(Color.green);
					H.setColor(Color.green);
				}
				if(back == 5){
					g.setColor(Color.blue);
					r.setColor(Color.blue);
					H.setColor(Color.blue);
				}
				if(back == 6){
					g.setColor(INDIGO);
					r.setColor(INDIGO);
					H.setColor(INDIGO);
				}
				if(back == 7){
					g.setColor(VIOLET);
					r.setColor(VIOLET);
					H.setColor(VIOLET);
				}
				if(back == 8){
					g.setColor(Color.pink);
					r.setColor(Color.pink);
					H.setColor(Color.pink);
				}
				if(back == 9){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 10){
					g.setColor(Color.black);
					r.setColor(Color.black);
					H.setColor(Color.black);
				}

				
				g.fillRect(p1.getX(), p1.getY(), width, height);
				g.drawImage(rotate, p1.getX(), p1.getY(), null);
				r.fillRect(p1.getX(), p1.getY(), width, height);
				r.drawImage(rotate, p1.getX(), p1.getY(), null);
				H.fillRect(p1.getX(), p1.getY(), width, height);
				H.drawImage(rotate, p1.getX(), p1.getY(), null);
				
				//rotate2의 색을 설정한다.
				//대칭한 후의 결과를 drawImage를 통해 보여준다.
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.red.getRGB());
						}
					}
				}
				g1.fillRect(p1.getX(), p1.getY(), width, height);
				g1.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.orange.getRGB());
						}
					}
				}
				g2.fillRect(p1.getX(), p1.getY(), width, height);
				g2.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.yellow.getRGB());
						}
					}
				}
				g3.fillRect(p1.getX(), p1.getY(), width, height);
				g3.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.green.getRGB());
						}
					}
				}
				g4.fillRect(p1.getX(), p1.getY(), width, height);
				g4.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.blue.getRGB());
						}
					}
				}
				g5.fillRect(p1.getX(), p1.getY(), width, height);
				g5.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, INDIGO.getRGB());
						}
					}
				}
				g6.fillRect(p1.getX(), p1.getY(), width, height);
				g6.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, VIOLET.getRGB());
						}
					}
				}
				g7.fillRect(p1.getX(), p1.getY(), width, height);
				g7.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.pink.getRGB());
						}
					}
				}
				g8.fillRect(p1.getX(), p1.getY(), width, height);
				g8.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.white.getRGB());
						}
					}
				}
				g9.fillRect(p1.getX(), p1.getY(), width, height);
				g9.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.black.getRGB());
						}
					}
				}
				g10.fillRect(p1.getX(), p1.getY(), width, height);
				g10.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				points2.add(0, p1);
				points2.add(p2);
				
				select = 20;
				
				H.setColor(Color.gray);
		      	H.drawRect(p1.getX(), p1.getY(), width, height);
		      	
				repaint();
			}
            //좌우 대칭--------------------------------------------------------------------------
            if(select == 24){
            	/**choose기능을 사용해 마우스로 원하는 영역을 선택한다.
				/*선택한 영역의 좌표 값을 얻어서 해당 영역의 길이와 높이를 구한다.
				 *구한 길이와 높이를 갖는 직사각형 영역 만큼의 정보를 갖는 새로운 버퍼 rotate와 rotate2를 생성한다.
				 */
				Graphics H = hid.getGraphics();
				H.drawImage(x, 0, 0, null);
				
				p1 =  (Point)points2.firstElement();
				p2 =  (Point)points2.lastElement();
				
				int x1 = Integer.min(p1.getX(), p2.getX());
				int x2 = Integer.max(p1.getX(), p2.getX());
				int y1 = Integer.min(p1.getY(), p2.getY());
				int y2 = Integer.max(p1.getY(), p2.getY());
				
				p1 = new Point(x1, y1);
				p2 = new Point(x2, y2);
				/**
				 * setRGB를 통해 각각의 픽셀 값을 받아온 후 두 개의 for문을 사용해 x,y 좌표의 위치를 바꾸었다.
				 * 바꾼 후 해당 정보를 rotate2버퍼에 적용시킨다.
				 * rotate는 도형의 대칭에 관여, rotate2는 도형의 색이 변하지 않도록 하는데 관여한다.
				 */
				width = p2.getX()-p1.getX();
				height = p2.getY()-p1.getY();
				rotate = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				rotate2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						rotate.setRGB(width - i - 1, j, x.getRGB(p1.getX() + i, p1.getY() + j));
					}
				}
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						rotate2.setRGB(i, j, rotate.getRGB(i, j));
					}
				}
				//현재 배경색에 대한 정보를 얻는다.
				if(back == 0){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 1){
					g.setColor(Color.red);
					r.setColor(Color.red);
					H.setColor(Color.red);
				}
				if(back == 2){
					g.setColor(Color.orange);
					r.setColor(Color.orange);
					H.setColor(Color.orange);
				}
				if(back == 3){
					g.setColor(Color.yellow);
					r.setColor(Color.yellow);
					H.setColor(Color.yellow);
				}
				if(back == 4){
					g.setColor(Color.green);
					r.setColor(Color.green);
					H.setColor(Color.green);
				}
				if(back == 5){
					g.setColor(Color.blue);
					r.setColor(Color.blue);
					H.setColor(Color.blue);
				}
				if(back == 6){
					g.setColor(INDIGO);
					r.setColor(INDIGO);
					H.setColor(INDIGO);
				}
				if(back == 7){
					g.setColor(VIOLET);
					r.setColor(VIOLET);
					H.setColor(VIOLET);
				}
				if(back == 8){
					g.setColor(Color.pink);
					r.setColor(Color.pink);
					H.setColor(Color.pink);
				}
				if(back == 9){
					g.setColor(Color.white);
					r.setColor(Color.white);
					H.setColor(Color.white);
				}
				if(back == 10){
					g.setColor(Color.black);
					r.setColor(Color.black);
					H.setColor(Color.black);
				}

				
				g.fillRect(p1.getX(), p1.getY(), width, height);
				g.drawImage(rotate, p1.getX(), p1.getY(), null);
				r.fillRect(p1.getX(), p1.getY(), width, height);
				r.drawImage(rotate, p1.getX(), p1.getY(), null);
				H.fillRect(p1.getX(), p1.getY(), width, height);
				H.drawImage(rotate, p1.getX(), p1.getY(), null);
				
				//rotate2의 색을 설정한다.
				//대칭한 후의 결과를 drawImage를 통해 보여준다.
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.red.getRGB());
						}
					}
				}
				g1.fillRect(p1.getX(), p1.getY(), width, height);
				g1.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.orange.getRGB());
						}
					}
				}
				g2.fillRect(p1.getX(), p1.getY(), width, height);
				g2.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.yellow.getRGB());
						}
					}
				}
				g3.fillRect(p1.getX(), p1.getY(), width, height);
				g3.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.green.getRGB());
						}
					}
				}
				g4.fillRect(p1.getX(), p1.getY(), width, height);
				g4.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.blue.getRGB());
						}
					}
				}
				g5.fillRect(p1.getX(), p1.getY(), width, height);
				g5.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, INDIGO.getRGB());
						}
					}
				}
				g6.fillRect(p1.getX(), p1.getY(), width, height);
				g6.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, VIOLET.getRGB());
						}
					}
				}
				g7.fillRect(p1.getX(), p1.getY(), width, height);
				g7.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.pink.getRGB());
						}
					}
				}
				g8.fillRect(p1.getX(), p1.getY(), width, height);
				g8.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.white.getRGB());
						}
					}
				}
				g9.fillRect(p1.getX(), p1.getY(), width, height);
				g9.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				for(i=0;i<width;i++){
					for(int j=0;j<height;j++){
						if(rotate.getRGB(i, j) == H.getColor().getRGB()){
							rotate2.setRGB(i, j, Color.black.getRGB());
						}
					}
				}
				g10.fillRect(p1.getX(), p1.getY(), width, height);
				g10.drawImage(rotate2, p1.getX(), p1.getY(), null);
				
				points2.add(0, p1);
				points2.add(p2);
				
				select = 20;
				
				H.setColor(Color.gray);
		      	H.drawRect(p1.getX(), p1.getY(), width, height);
		      	
				repaint();
			}
            // 격자선----------------------------------------------------------------------------
            if(select==17)
            {
				int k;
				//for문을 사용해 가로와 세로의 직선을 연속해서 생성하였다.
				for(k=0;k<1000;k=k+20)
				{

			      	g.drawLine(k,0,k,1000);
					g1.drawLine(k,0,k,1000);
					g2.drawLine(k,0,k,1000);		  
					g3.drawLine(k,0,k,1000);	
					g4.drawLine(k,0,k,1000);
					g5.drawLine(k,0,k,1000);
					g6.drawLine(k,0,k,1000);		 
					g7.drawLine(k,0,k,1000);		  
					g8.drawLine(k,0,k,1000);
					g9.drawLine(k,0,k,1000);
					g10.drawLine(k,0,k,1000);
		  
				}				
				for(k=0;k<1000;k=k+20)
				{

		      		g.drawLine(0,k,1000,k);
		      		g1.drawLine(0,k,1000,k);
		      		g2.drawLine(0,k,1000,k);
		      		g3.drawLine(0,k,1000,k);
		      		g4.drawLine(0,k,1000,k);
		      		g5.drawLine(0,k,1000,k);
		      		g6.drawLine(0,k,1000,k);
		      		g7.drawLine(0,k,1000,k);
		      		g8.drawLine(0,k,1000,k);
		      		g9.drawLine(0,k,1000,k);
		      		g10.drawLine(0,k,1000,k);
				}
            }
            // 선택 후 복사-----------------------------------------------------------------------
            if(select==18) 
            {
            			if(copyCheck ==0) {
        	             p1 = (Point)points.firstElement();
        	             p2 = (Point)points.lastElement();
        	             width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
        	             height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
        	             r.setColor(Color.gray);
        	             r.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
        	             copyX = Integer.min(p1.getX(), p2.getX());
        	             copyY= Integer.min(p1.getY(), p2.getY());
        	             copyWidth = width;
        	             copyHeight= height;
                     }
                      
                     else
                     {          	 
                    	 p2=(Point)points.lastElement();
                    	 r.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());

                     }

            }
            //선택 후 이동-------------------------------------------------------------------------
            if(select==19) 
            {
                if(copyCheck ==0) {
    	             p1 = (Point)points.firstElement();
    	             p2 = (Point)points.lastElement();
    	             width = Integer.max(p2.getX() - p1.getX(), p1.getX() - p2.getX());
    	             height =  Integer.max(p2.getY() - p1.getY(), p1.getY() - p2.getY());
       	             r.setColor(Color.gray);
    	             r.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
    	             copyX = Integer.min(p1.getX(), p2.getX());
    	             copyY= Integer.min(p1.getY(), p2.getY());
    	             copyWidth = width;
    	             copyHeight= height;

                 }
                 else
                 {          	 
               	 p2=(Point)points.lastElement();
                	 r.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());      	 
                 }
            }
            
                 
          // 도형 을 그렸을 때 바로 뜨게 하기 위함---------------------------------------------------------
   			if (back==0)
			{       		
				g.drawImage(x, 0, 0, this);
			}
			if (back==1)
			{       
				
				g.drawImage(C1, 0, 0, this);
			}
			if (back==2)
			{
				g.drawImage(C2, 0, 0, this);
			}
			if (back==3)
			{
				g.drawImage(C3, 0, 0, this);
			}
			if (back==4)
			{
				g.drawImage(C4, 0, 0, this);
			}
			if (back==5)
			{
				g.drawImage(C5, 0, 0, this);
			}
			if (back==6)
			{
				g.drawImage(C6, 0, 0, this);
			}
			if (back==7)
			{
				g.drawImage(C7, 0, 0, this);
			}
			if (back==8)
			{
				g.drawImage(C8, 0, 0, this);
			}
			if (back==9)
			{
				g.drawImage(C9, 0, 0, this);
			}
			if (back==10)
			{
				g.drawImage(C10, 0, 0, this);
			}
			if(back >= 1 && back <= 10){
				repaint();
			}
			
			
			g.dispose();
		}
		// 마우스를 눌렀을 때 이벤트 발생
		public void mousePressed(MouseEvent e){
			// 마우스를 눌렀을 때  좌표 저장 값을 초기화
			points.clear(); 
		    
		    int x = e.getX();
		    int y = e.getY();
		    Point p = new Point(x, y);
		    // 새로운 좌표들 저장
		    points.add(0, p);
		    	repaint();
			};
		// 마우스 누른거 해제 했을 때 이벤트 발생
		// 이 함수가 없다면 이미지가 마우스를 떼는 동시에 사라진다.
		public void mouseReleased(MouseEvent e){
			// 버퍼이미지에 대한 그래픽 얻기--------------------------------------------
			Graphics g = x.getGraphics();
			Graphics g1 = C1.getGraphics();
			Graphics g2 = C2.getGraphics();
			Graphics g3 = C3.getGraphics();
			Graphics g4 = C4.getGraphics();
			Graphics g5 = C5.getGraphics();
			Graphics g6 = C6.getGraphics();
			Graphics g7 = C7.getGraphics();
			Graphics g8 = C8.getGraphics();
			Graphics g9 = C9.getGraphics();
			Graphics g10 = C10.getGraphics();
			Graphics H= hid.getGraphics();
			
			//선두께를 조정하기 위함(Setstroke 메소드 사용)--------------------------------
		    Graphics2D L=(Graphics2D)g;
		    Graphics2D L1=(Graphics2D)g1;
		    Graphics2D L2=(Graphics2D)g2;
		    Graphics2D L3=(Graphics2D)g3;
		    Graphics2D L4=(Graphics2D)g4;
		    Graphics2D L5=(Graphics2D)g5;
		    Graphics2D L6=(Graphics2D)g6;
		    Graphics2D L7=(Graphics2D)g7;
		    Graphics2D L8=(Graphics2D)g8;
		    Graphics2D L9=(Graphics2D)g9;
		    Graphics2D L10=(Graphics2D)g10;
	        //색깔 선택--------------------------------------------------------
            if (color == 0) {
 
                g.setColor(Color.black);
                g1.setColor(Color.black);
                g2.setColor(Color.black);
                g3.setColor(Color.black);
                g4.setColor(Color.black);
                g5.setColor(Color.black);
                g6.setColor(Color.black);
                g7.setColor(Color.black);
                g8.setColor(Color.black);
                g9.setColor(Color.black);
                g10.setColor(Color.black);
 
             
        }
            if (color == 1) {
     
                g.setColor(Color.red);
                g1.setColor(Color.red);
                g2.setColor(Color.red);
                g3.setColor(Color.red);
                g4.setColor(Color.red);
                g5.setColor(Color.red);
                g6.setColor(Color.red);
                g7.setColor(Color.red);
                g8.setColor(Color.red);
                g9.setColor(Color.red);
                g10.setColor(Color.red);
             
        }  
            if (color == 2) {
    
                g.setColor(Color.orange);
                g1.setColor(Color.orange);
                g2.setColor(Color.orange);
                g3.setColor(Color.orange);
                g4.setColor(Color.orange);
                g5.setColor(Color.orange);
                g6.setColor(Color.orange);
                g7.setColor(Color.orange);
                g8.setColor(Color.orange);
                g9.setColor(Color.orange);
                g10.setColor(Color.orange);
             
        }       
            if (color == 3) {
   
                g.setColor(Color.yellow);
                g1.setColor(Color.yellow);
                g2.setColor(Color.yellow);
                g3.setColor(Color.yellow);
                g4.setColor(Color.yellow);
                g5.setColor(Color.yellow);
                g6.setColor(Color.yellow);
                g7.setColor(Color.yellow);
                g8.setColor(Color.yellow);
                g9.setColor(Color.yellow);
                g10.setColor(Color.yellow);
             
        }       
            if (color == 4) {
       
                g.setColor(Color.green);
                g1.setColor(Color.green);
                g2.setColor(Color.green);
                g3.setColor(Color.green);
                g4.setColor(Color.green);
                g5.setColor(Color.green);
                g6.setColor(Color.green);
                g7.setColor(Color.green);
                g8.setColor(Color.green);
                g9.setColor(Color.green);
                g10.setColor(Color.green);
            
        }
            if (color == 5) {
        
                g.setColor(Color.blue);
                g1.setColor(Color.blue);
                g2.setColor(Color.blue);
                g3.setColor(Color.blue);
                g4.setColor(Color.blue);
                g5.setColor(Color.blue);
                g6.setColor(Color.blue);
                g7.setColor(Color.blue);
                g8.setColor(Color.blue);
                g9.setColor(Color.blue);
                g10.setColor(Color.blue);
           
        }
            if (color == 6) {
   
                g.setColor(INDIGO);
                g1.setColor(INDIGO);
                g2.setColor(INDIGO);
                g3.setColor(INDIGO);
                g4.setColor(INDIGO);
                g5.setColor(INDIGO);
                g6.setColor(INDIGO);
                g7.setColor(INDIGO);
                g8.setColor(INDIGO);
                g9.setColor(INDIGO);
                g10.setColor(INDIGO);
      
        } 
            if (color == 7) {

                g.setColor(VIOLET);
                g1.setColor(VIOLET);
                g2.setColor(VIOLET);
                g3.setColor(VIOLET);
                g4.setColor(VIOLET);
                g5.setColor(VIOLET);
                g6.setColor(VIOLET);
                g7.setColor(VIOLET);
                g8.setColor(VIOLET);
                g9.setColor(VIOLET);
                g10.setColor(VIOLET);
          
        }
            if (color == 8) {
       
	            g.setColor(Color.pink);
	            g1.setColor(Color.pink);
	            g2.setColor(Color.pink);
	            g3.setColor(Color.pink);
	            g4.setColor(Color.pink);
	            g5.setColor(Color.pink);
	            g6.setColor(Color.pink);
	            g7.setColor(Color.pink);
	            g8.setColor(Color.pink);
	            g9.setColor(Color.pink);
	            g10.setColor(Color.pink);
           
        } 
            if (color == 9) {
        
                g.setColor(Color.white);
                g1.setColor(Color.white);
                g2.setColor(Color.white);
                g3.setColor(Color.white);
                g4.setColor(Color.white);
                g5.setColor(Color.white);
                g6.setColor(Color.white);
                g7.setColor(Color.white);
                g8.setColor(Color.white);
                g9.setColor(Color.white);
                g10.setColor(Color.white);
      
        }
            if (color == 10) {
                g.setColor(Color.black);
                g1.setColor(Color.black);
                g2.setColor(Color.black);
                g3.setColor(Color.black);
                g4.setColor(Color.black);
                g5.setColor(Color.black);
                g6.setColor(Color.black);
                g7.setColor(Color.black);
                g8.setColor(Color.black);
                g9.setColor(Color.black);
                g10.setColor(Color.black);
        }
            
            // 선두께 조정----------------------------------------------------------
            switch(thick) {
            case 1:
            	L.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L1.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L3.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L4.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L5.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L6.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L7.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L8.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L9.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	L10.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,0));
            	break;
            	
            case 2:
            	L.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L1.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L2.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L3.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L4.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L5.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L6.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L7.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L8.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L9.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	L10.setStroke(new BasicStroke(4,BasicStroke.CAP_BUTT,0));
            	break;
            	
            case 3:
            	L.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L1.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L2.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L3.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L4.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L5.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L6.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L7.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L8.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L9.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	L10.setStroke(new BasicStroke(7,BasicStroke.CAP_BUTT,0));
            	break;
            	
            case 4:
            	L.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L1.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L2.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L3.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L4.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L5.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L6.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L7.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L8.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L9.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	L10.setStroke(new BasicStroke(10,BasicStroke.CAP_BUTT,0));
            	break;
            
            }
            
            
			// 마우스의 클릭을 해제 했을 때 그림이 사라지는 것을 방지
			switch(select){
			// 원 그리기---------------------------------------------------------------
			case 1:
				{
					g.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height); 
					g1.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g2.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g3.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g4.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g5.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g6.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g7.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g8.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g9.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g10.drawOval(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					
				}break;
			// 삼각형 그리기-------------------------------------------------------------------
			case 2:
			{
	        	 int x1,x2,y1,y2;
			     int xPoints[] = new int[3];
			     int yPoints[] = new int[3];
			     p1 = (Point)points.firstElement();
			     p2 = (Point)points.lastElement();
			    	
			     x1 = Integer.min(p1.getX(), p2.getX());
			     x2 = Integer.max(p1.getX(), p2.getX());
			     y1 = Integer.min(p1.getY(), p2.getY());
			     y2 = Integer.max(p1.getY(), p2.getY());
			    
			     //세 꼭짓점의 위치 구하기
			     xPoints[0]=x1;
			     xPoints[1]=(x1+x2)/2;
			     xPoints[2]=x2;
			     
			     yPoints[0]=y2;
			     yPoints[1]=y1;
			     yPoints[2]=y2;
			     
			     g.drawPolygon(xPoints,yPoints,xPoints.length);
			     g.drawPolygon(xPoints,yPoints,xPoints.length);
			     g1.drawPolygon(xPoints,yPoints,xPoints.length);
			     g2.drawPolygon(xPoints,yPoints,xPoints.length);
			     g3.drawPolygon(xPoints,yPoints,xPoints.length);
			     g4.drawPolygon(xPoints,yPoints,xPoints.length);
			     g5.drawPolygon(xPoints,yPoints,xPoints.length);
			     g6.drawPolygon(xPoints,yPoints,xPoints.length);
			     g7.drawPolygon(xPoints,yPoints,xPoints.length);
			     g8.drawPolygon(xPoints,yPoints,xPoints.length);
			     g9.drawPolygon(xPoints,yPoints,xPoints.length);
			     g10.drawPolygon(xPoints,yPoints,xPoints.length);
			     
			}break;
			// 사각형 그리기---------------------------------------------------------------------
			case 3:
				{
					g.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g1.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g2.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g3.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g4.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g5.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g6.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g7.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g8.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g9.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					g10.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
					
				}break;
			// 둥근 사각형 그리기-----------------------------------------------------------------
			case 4:
				{
					g.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g1.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g2.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g3.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g4.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g5.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g6.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g7.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g8.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g9.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					g10.drawRoundRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height,30,30);
					
				}break;
			// 오각형 그리기------------------------------------------------------------------
			case 5:
			{
				int x1, x2, y1, y2;
				int xPoints[] = new int[5];
				int yPoints[] = new int[5];
				p1 = (Point)points.firstElement();
				p2 = (Point)points.lastElement();
	    	
				x1 = Integer.min(p1.getX(), p2.getX());
				x2 = Integer.max(p1.getX(), p2.getX());
				y1 = Integer.min(p1.getY(), p2.getY());
				y2 = Integer.max(p1.getY(), p2.getY());
				
		    	xPoints[0] = (x1 + x2)/2;
		    	xPoints[1] = x1;
		    	xPoints[2] = (3*x1+x2)/4;
		    	xPoints[3] = (x1+3*x2)/4;
		    	xPoints[4] = x2;

		    	yPoints[0] = y1;
		    	yPoints[1] = (y1+y2)/2;
		    	yPoints[2] = y2;
		    	yPoints[3] = y2;
		    	yPoints[4] = (y1+y2)/2;
		    	
		    	g.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g1.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g2.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g3.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g4.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g5.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g6.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g7.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g8.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g9.drawPolygon(xPoints,yPoints,xPoints.length);
		    	g10.drawPolygon(xPoints,yPoints,xPoints.length);
		
			}    	break;
			// 직선 그리기-------------------------------------------------------------
			case 6:
				{
					g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g1.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g2.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g3.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g4.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g5.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g6.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g7.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g8.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g9.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g10.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					
				}break;
			// 자율그리기---------------------------------------------------------------
			case 7:
			{
				num = points.size(); 
				System.out.println(num);
				p1 = (Point)points.firstElement();
				for(int j = 1; j < num; j++) {
					p2 = (Point)points.elementAt(j);
					g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g1.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g2.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g3.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g4.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g5.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g6.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g7.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g8.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g9.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					g10.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
					p1 = p2;
				} 
			}break;
			// 텍스트입력------------------------------------------------------------------
			case 8:
			{
			  	p1 = (Point)points.lastElement();
			  	g.drawString(Text,p1.getX(), p1.getY());
			  	g1.drawString(Text,p1.getX(), p1.getY());
			  	g2.drawString(Text,p1.getX(), p1.getY());
			  	g3.drawString(Text,p1.getX(), p1.getY());
			  	g4.drawString(Text,p1.getX(), p1.getY());
			  	g5.drawString(Text,p1.getX(), p1.getY());
			  	g6.drawString(Text,p1.getX(), p1.getY());
			  	g7.drawString(Text,p1.getX(), p1.getY());
			  	g8.drawString(Text,p1.getX(), p1.getY());
			  	g9.drawString(Text,p1.getX(), p1.getY());
			  	g10.drawString(Text,p1.getX(), p1.getY());	
			}break;

			// 불러오기---------------------------------------------------------------------
			case 9:
				{
					p1=new Point(e.getX(),e.getY());
					g.drawImage(img, 0, 0, null);
					g1.drawImage(img, 0, 0, null);
					g2.drawImage(img, 0, 0, null);
					g3.drawImage(img, 0, 0, null);
					g4.drawImage(img, 0, 0, null);
					g5.drawImage(img, 0, 0, null);
					g6.drawImage(img, 0, 0, null);
					g7.drawImage(img, 0, 0, null);
					g8.drawImage(img, 0, 0, null);
					g9.drawImage(img, 0, 0, null);
					g10.drawImage(img, 0, 0, null);
				}break;
			// 선택 후 복사---------------------------------------------------------------------
			case 18:
			{
	             if(copyCheck == 0) {
	                 copyCheck = 1;	                 
	            	 }	
	            else {
	   	          	 g.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g1.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g2.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g3.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g4.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g5.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g6.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g7.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g8.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g9.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   	          	 g10.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());	   	           
	   	             copyCheck=0;
	                }
			}break;
			// 선택 후 이동-----------------------------------------------------------------------
			case 19:
			{
	             if(copyCheck == 0) {
	                 copyCheck = 1;
	            	 }	
	                else {
	   	            	  g.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g.setColor(Color.white);
	   		              g.fillRect(copyX, copyY, copyWidth, copyHeight);
	   	            	  g1.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g1.setColor(Color.red);
	   		              g1.fillRect(copyX, copyY, copyWidth, copyHeight);
	   	            	  g2.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g2.setColor(Color.orange);
	   		              g2.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g3.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g3.setColor(Color.yellow);
	   		              g3.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g4.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g4.setColor(Color.green);
	   		              g4.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g5.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g5.setColor(Color.blue);
	   		              g5.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g6.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g6.setColor(INDIGO);
	   		              g6.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g7.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g7.setColor(VIOLET);
	   		              g7.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g8.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g8.setColor(Color.pink);
	   		              g8.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g9.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g9.setColor(Color.white);
	   		              g9.fillRect(copyX, copyY, copyWidth, copyHeight);	  
	   	            	  g10.copyArea(copyX, copyY, copyWidth, copyHeight, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	   		        	  g10.setColor(Color.black);
	   		              g10.fillRect(copyX, copyY, copyWidth, copyHeight);	
	 	   	              copyCheck = 0;
	   	             }                
			}break;
			// 대칭 및 회전 할 때 선택---------------------------------------------------------------
			case 20:
			{
				switch(back) {
				
				
				case 0: 
					H.drawImage(x, 0, 0, null);

					break;
				case 1: 
					H.drawImage(C1, 0, 0, null);

					break;
				case 2: 
					H.drawImage(C2, 0, 0, null);

					break;
				case 3: 
					H.drawImage(C3, 0, 0, null);

				case 4: 
					H.drawImage(C4, 0, 0, null);

					break;
				case 5: 
					H.drawImage(C5, 0, 0, null);

					break;
				case 6: 
					H.drawImage(C6, 0, 0, null);

					break;
				case 7: 
					H.drawImage(C7, 0, 0, null);

					break;
				case 8: 
					H.drawImage(C8, 0, 0, null);

					break;
				case 9: 
					H.drawImage(C9, 0, 0, null);

					break;
				case 10: 
					H.drawImage(C10, 0, 0, null);

					break;
					
				};
		      	H.drawRect(Integer.min(p1.getX(), p2.getX()), Integer.min(p1.getY(), p2.getY()), width, height);
		      	points2.clear();
		      	points2.addAll(points);
			}break;
			
			}
			// 채우기에 사용(도형 정보 저장)-------------------------------------------------------------
			if(select==1||select==2||select==3||select==4||select==5)
			{
				sv[num]=new save_shape();
				sv[num].select=select;
				sv[num].color=color;
				sv[num++].points.addAll(points);
			}
			// 좌표값을 지우고 새로운 좌표 값을 받음
			points.clear();
			int x=e.getX();
			int y=e.getY();
			Point p=new Point(x,y);
			points.add(0,p);
			repaint();
	    }
		// 마우스를 클릭했을 때 이벤트 발생
		public void mouseClicked(MouseEvent e)
		{
			points.clear();
		    
		    int x = e.getX();
		    int y = e.getY();
		    Point p = new Point(x, y);
		    points.add(0, p);
		    repaint();
		}
		// 마우스를 DrawPanel 안에 들어가게 했을 때 이벤트 발생
		public void mouseEntered(MouseEvent e){}
		// 마우스를 DrawPanel 에서 나왔을 때 이벤트 발생
		public void mouseExited(MouseEvent e){}
		// 마우스를 드레그 했을 때 이벤트 발생
		public void mouseDragged(MouseEvent e){
		    int x = e.getX();
		    int y = e.getY();
		    Point p = new Point(x, y);
		    points.add(p);
		    repaint();
		}
		// 마우스를 움직였을 때 이벤트 발생
		public void mouseMoved(MouseEvent e){}
	}
	// 좌표값을 얻어오는 Class
	static class Point{
		  private int x;
		  private int y;
		  //  좌표값을 얻어옴
		  public Point(int x, int y) {
		    this.x = x;
		    this.y = y;
		  }
		  // x좌표 리턴
		  public int getX(){
			  return x;
		  }
		  // y좌표 리턴
		  public int getY(){
			  return y;
		  }
	}
	// 도형 저장 하기 위한 class
	static class save_shape{
		Image img = null;
		Vector points;
		int select = 0;
		int color;
		
		save_shape(){
			points = new Vector();
		}
	}
	// 메인 함수
	public static void main(String[] args) {
		new MyGUI();
	}

}
