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
	public  MyBarPanel() throws ClassNotFoundException, SQLException, IOException{//柱形图
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createBarChart3D(
				"待办统计", // 图表标题
				"待办事项", // 目录轴的显示标签
				"锁机时长", // 数值轴的显示标签
				dataset,
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true,           // 是否显示图例(对于简单的柱状图必须是false)
				false,          // 是否生成工具
				false           // 是否生成URL链接
		);

		//从这里开始
		CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象
		CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表
		domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
		ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体


		//到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题

		frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame

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





