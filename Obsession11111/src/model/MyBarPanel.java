package model;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.channels.Channel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class MyBarPanel {
	ChartPanel frame1;
	public  MyBarPanel() throws ClassNotFoundException, SQLException, IOException{//����ͼ
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createBarChart3D(
				"����ͳ��", // ͼ�����
				"��������", // Ŀ¼�����ʾ��ǩ
				"����ʱ��", // ��ֵ�����ʾ��ǩ
				dataset,
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
				false,          // �Ƿ����ɹ���
				false           // �Ƿ�����URL����
		);

		//�����￪ʼ
		CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������
		CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�
		domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����
		domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
		ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״
		rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������


		//�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������

		frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame

	}

	private CategoryDataset getDataSet() throws SQLException, ClassNotFoundException {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		User u = new User();
		List<Data> st = new ArrayList<Data>();
		ArrayList<Data> list = u.AllStu();
		for (Data s : list) {
			dataset.addValue(s.getTime(),s.getThing(),s.getThing());
		}
		return dataset;
	}

	public Component getChartPanel(){
		return frame1;

	}

}





