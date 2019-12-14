eclipse环境下使用substance.jar方法如下：

选中当前工程，打开菜单栏的project，选择properties——>Java Build Path--->Libraries

-->Add External JARs...,添加你要加入的.jar包（在这里也就是Substance.jar）

然后在主函数中加入

try { 
UIManager.setLookAndFeel(new SubstanceLookAndFeel()); 
UIManager.put("swing.boldMetal", false); 
if (System.getProperty("substancelaf.useDecorations") == null) { 
JFrame.setDefaultLookAndFeelDecorated(true); 
JDialog.setDefaultLookAndFeelDecorated(true); 
} 
System.setProperty("sun.awt.noerasebackground", "true"); 
SubstanceLookAndFeel.setCurrentTheme(new SubstanceLightAquaTheme());//设置当前的主题风格，同样我 们还可以设置当前的按钮形状，水印风格等等 
} catch (Exception e) { 
System.err.println("Oops! Something went wrong!"); 
}

你可以把那些代码看懂，同时打开Substance.jar包，

那里有很多风格，你自己看着改！