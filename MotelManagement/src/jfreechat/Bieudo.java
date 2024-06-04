package jfreechat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bieudo extends JFrame {

    public Bieudo(String title) {
        super(title);
        setAutoRequestFocus(false);

        // Tạo dataset giả định với dữ liệu tiền điện trong 12 tháng
        CategoryDataset dataset = createDataset();

        // Tạo biểu đồ từ dataset
        JFreeChart chart = ChartFactory.createLineChart(
                "Tăng trưởng Tiền Điện trong 12 Tháng",
                "Tháng",
                "Tiền Điện",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // Tùy chỉnh biểu đồ nếu cần thiết
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // Hiển thị biểu đồ trong JFrame
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 370));
        setContentPane(chartPanel);
        chartPanel.setLayout(null);
        
        JButton btnNewButton = new JButton("Thoát");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 dispose();
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBounds(465, 339, 85, 21);
        chartPanel.add(btnNewButton);

        // Cài đặt các thuộc tính của JFrame
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Sử dụng pack() để cài đặt kích thước JFrame tự động dựa trên nội dung
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Thêm dữ liệu giả định
        dataset.addValue(6351700, "Tiền Điện", "Tháng 1");
        dataset.addValue(7984500, "Tiền Điện", "Tháng 2");
        dataset.addValue(5978106, "Tiền Điện", "Tháng 3");
        dataset.addValue(6798125, "Tiền Điện", "Tháng 4");
        dataset.addValue(7886512, "Tiền Điện", "Tháng 5");
        dataset.addValue(8889455, "Tiền Điện", "Tháng 6");
        dataset.addValue(5785640, "Tiền Điện", "Tháng 7");
        dataset.addValue(4798510, "Tiền Điện", "Tháng 8");
        dataset.addValue(7565120, "Tiền Điện", "Tháng 9");
        dataset.addValue(7653233, "Tiền Điện", "Tháng 10");
        dataset.addValue(7851232, "Tiền Điện", "Tháng 11");
        dataset.addValue(5798512, "Tiền Điện", "Tháng 12");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bieudo ("Biểu Đồ Tiền Điện"));
    }
}
