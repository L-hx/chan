eclipse������ʹ��substance.jar�������£�

ѡ�е�ǰ���̣��򿪲˵�����project��ѡ��properties����>Java Build Path--->Libraries

-->Add External JARs...,�����Ҫ�����.jar����������Ҳ����Substance.jar��

Ȼ�����������м���

try { 
UIManager.setLookAndFeel(new SubstanceLookAndFeel()); 
UIManager.put("swing.boldMetal", false); 
if (System.getProperty("substancelaf.useDecorations") == null) { 
JFrame.setDefaultLookAndFeelDecorated(true); 
JDialog.setDefaultLookAndFeelDecorated(true); 
} 
System.setProperty("sun.awt.noerasebackground", "true"); 
SubstanceLookAndFeel.setCurrentTheme(new SubstanceLightAquaTheme());//���õ�ǰ��������ͬ���� �ǻ��������õ�ǰ�İ�ť��״��ˮӡ���ȵ� 
} catch (Exception e) { 
System.err.println("Oops! Something went wrong!"); 
}

����԰���Щ���뿴����ͬʱ��Substance.jar����

�����кܶ������Լ����Ÿģ�