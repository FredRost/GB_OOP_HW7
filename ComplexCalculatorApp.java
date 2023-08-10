import java.util.logging.Logger;

// Интерфейс для операций с комплексными числами
interface ComplexCalculator {
    ComplexNumber add(ComplexNumber num1, ComplexNumber num2);
    ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2);
    ComplexNumber divide(ComplexNumber dividend, ComplexNumber divisor);
}

// Класс представления комплексного числа
class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}

// Реализация калькулятора комплексных чисел
class SimpleComplexCalculator implements ComplexCalculator {
    @Override
    public ComplexNumber add(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getReal() + num2.getReal();
        double imaginaryPart = num1.getImaginary() + num2.getImaginary();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double imaginaryPart = num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public ComplexNumber divide(ComplexNumber dividend, ComplexNumber divisor) {
        double divisorSquared = divisor.getReal() * divisor.getReal() + divisor.getImaginary() * divisor.getImaginary();
        double realPart = (dividend.getReal() * divisor.getReal() + dividend.getImaginary() * divisor.getImaginary()) / divisorSquared;
        double imaginaryPart = (dividend.getImaginary() * divisor.getReal() - dividend.getReal() * divisor.getImaginary()) / divisorSquared;
        return new ComplexNumber(realPart, imaginaryPart);
    }
}

// Пример использования
public class ComplexCalculatorApp {
    private static final Logger logger = Logger.getLogger(ComplexCalculatorApp.class.getName());

    public static void main(String[] args) {
        ComplexCalculator calculator = new SimpleComplexCalculator();

        ComplexNumber num1 = new ComplexNumber(3, 2);
        ComplexNumber num2 = new ComplexNumber(1, -1);

        ComplexNumber sum = calculator.add(num1, num2);
        ComplexNumber product = calculator.multiply(num1, num2);
        ComplexNumber quotient = calculator.divide(num1, num2);

        logger.info("Sum: " + sum.getReal() + " + " + sum.getImaginary() + "i");
        logger.info("Product: " + product.getReal() + " + " + product.getImaginary() + "i");
        logger.info("Quotient: " + quotient.getReal() + " + " + quotient.getImaginary() + "i");
    }
}
