package cn.backpackerxl.util;
/**
 * @author: backpackerxl
 * @create: 2021/10/28
 * @filename: VerificationCode
 **/

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class VerificationCode {
    //定义验证码的宽高
    private static int WIDTH = 70;
    private static int HEIGHT = 35;

    /**
     * 获取验证码图片
     *
     * @return
     */
    public static void getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("image/jpeg");
        ServletOutputStream sos = response.getOutputStream();
        //设置浏览器不要缓存验证码图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        char[] rands = generateCheckCode();
        //开始画图
        drawBackground(graphics);
        draeRands(graphics, rands);
        //结束画图
        graphics.dispose();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "JPEG", bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentLength(bos.toByteArray().length);
        bos.writeTo(sos);
        //保存验证码
        session.setAttribute("checkLoginCode", new String(rands));
    }

    /**
     * 将10个数字和所有大小写字母随机生成4个字符验证码
     *
     * @return
     */
    public static char[] generateCheckCode() {
        //定义字符表
        String chars = "0123456789qazxswedcvfrbgtnhymjukilopQAZXSWCDERFVBGTYHNMJUIKLOP";
        char[] rands = new char[4];
        for (int i = 0; i < 4; i++) {
            int rand = (int) (Math.random() * 61);
            rands[i] = chars.charAt(rand);
        }
        return rands;
    }

    /**
     * 为验证码图片图一个背景颜色
     *
     * @param graphics
     */
    private static void drawBackground(Graphics graphics) {
        graphics.setColor(new Color(0xFFFFFFFF));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        //在背景中随机生成130个干扰点
        for (int i = 0; i < 130; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            graphics.setColor(new Color(red, green, blue));
            graphics.drawOval(x, y, 1, 0);
        }
    }

    /**
     * 将随机生成的验证码和图片相结合
     *
     * @param graphics
     * @param rands
     */
    private static void draeRands(Graphics graphics, char[] rands) {
        graphics.setFont(new Font(null, Font.ITALIC | Font.BOLD, 20));
        int[][] position = {{1,17}, {16,15}, {31,18}, {46,16}};
        //在不同的高度输出每一个字符,并动态设置字体颜色
        for (int i = 0; i < 4; i++) {
            graphics.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
            graphics.drawString("" + rands[i], position[i][0], position[i][1]);
        }
//        System.out.println(rands);
    }
}
