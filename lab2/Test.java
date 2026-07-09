// คลาสสำหรับสร้าง Object เลขเชิงซ้อน
class Complex {
    private double r, i; // r = ส่วนจริง (real), i = ส่วนจินตภาพ (imaginary) [cite: 139, 151]

    // Constructor รับค่าส่วนจริงและส่วนจินตภาพ [cite: 152]
    Complex(double r, double i) {
        this.r = r; [cite: 154]
        this.i = i; [cite: 154]
    }

    // Copy Constructor สำหรับสร้าง Object ใหม่จาก Object เดิม [cite: 155]
    Complex(Complex c) {
        this(c.r, c.i); [cite: 156]
    }

    // เมธอดบวก (มีอยู่แล้วในโจทย์) [cite: 158]
    public void add(Complex c) {
        r += c.r; [cite: 159]
        i += c.i; [cite: 160]
    }

    // 1. เพิ่มเมธอด "ลบ"
    public void subtract(Complex c) {
        this.r -= c.r;
        this.i -= c.i;
    }

    // 2. เพิ่มเมธอด "คูณ"
    public void multiply(Complex c) {
        // ต้องสร้างตัวแปรชั่วคราว (temp) มาเก็บค่าไว้ก่อน
        // เพราะถ้าเราแก้ค่า r ไปเลย ค่า i ที่คำนวณทีหลังจะเพี้ยนครับ
        double tempR = (this.r * c.r) - (this.i * c.i);
        double tempI = (this.r * c.i) + (this.i * c.r);
        
        this.r = tempR;
        this.i = tempI;
    }

    // 3. เพิ่มเมธอด "หาร"
    public void divide(Complex c) {
        // คำนวณตัวส่วน (Denominator) คือ c^2 + d^2
        double denominator = (c.r * c.r) + (c.i * c.i);
        
        // ป้องกันการหารด้วย 0
        if (denominator != 0) {
            double tempR = ((this.r * c.r) + (this.i * c.i)) / denominator;
            double tempI = ((this.i * c.r) - (this.r * c.i)) / denominator;
            
            this.r = tempR;
            this.i = tempI;
        } else {
            System.out.println("Error: Cannot divide by zero.");
        }
    }

    // เมธอดแสดงผล (มีอยู่แล้วในโจทย์) [cite: 162]
    public void print() {
        System.out.println(r + " + " + i + "i"); [cite: 163]
    }
}

// คลาสสำหรับทดสอบการทำงาน [cite: 164]
public class ComplexTest {
    public static void main(String[] args) {
        // สร้าง Object เลขเชิงซ้อนตั้งต้น
        Complex a = new Complex(1.0, 2.0); // 1.0 + 2.0i [cite: 168, 169]
        Complex b = new Complex(3.0, 4.0); // 3.0 + 4.0i [cite: 170, 171]

        System.out.print("a = ");
        a.print();
        System.out.print("b = ");
        b.print();
        System.out.println("-------------------");

        // ทดสอบการบวก
        Complex cAdd = new Complex(a); [cite: 172]
        cAdd.add(b); [cite: 173]
        System.out.print("a + b = ");
        cAdd.print(); [cite: 174]

        // ทดสอบการลบ
        Complex cSub = new Complex(a);
        cSub.subtract(b);
        System.out.print("a - b = ");
        cSub.print();

        // ทดสอบการคูณ
        Complex cMul = new Complex(a);
        cMul.multiply(b);
        System.out.print("a * b = ");
        cMul.print();

        // ทดสอบการหาร
        Complex cDiv = new Complex(a);
        cDiv.divide(b);
        System.out.print("a / b = ");
        cDiv.print();
    }
}