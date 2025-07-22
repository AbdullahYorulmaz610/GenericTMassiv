import java.util.Arrays;

public class Main {


    public static <T> void elementlerinYeriniDeyis(T[] massiv, int index1, int index2) {
        // Parametrlərin düzgünlüyünü yoxlayırıq
        if (massiv == null || index1 < 0 || index2 < 0 || index1 >= massiv.length || index2 >= massiv.length) {
            System.out.println("Xəta: Massiv boşdur və ya indekslər massivin hüdudlarından kənardadır.");
            // throw new IndexOutOfBoundsException("Indekslər massivin hüdudlarından kənardadır.");
            return; // Metodun işini dayandırırıq
        }

        // Yer dəyişmə alqoritmi
        T muveqqetiElement = massiv[index1]; // 1-ci elementin dəyərini müvəqqəti yadda saxlayırıq
        massiv[index1] = massiv[index2];     // 2-ci elementin dəyərini 1-cinin yerinə yazırıq
        massiv[index2] = muveqqetiElement;   // Müvəqqəti saxlanan dəyəri 2-cinin yerinə yazırıq
    }

    public static void main(String[] args) {
        // --- Integer (Tam ədəd) massivi ilə test ---
        System.out.println("--- Tam Ədəd Massivi Testi ---");
        Integer[] reqemler = {10, 20, 30, 40, 50};
        System.out.println("Dəyişmədən əvvəl: " + Arrays.toString(reqemler));

        // 1-ci indeks (dəyəri 20) ilə 3-cü indeksin (dəyəri 40) yerini dəyişək
        elementlerinYeriniDeyis(reqemler, 1, 3);

        System.out.println("Dəyişmədən sonra:  " + Arrays.toString(reqemler));
        System.out.println("--------------------------------\n");


        // --- String (Mətn) massivi ilə test ---
        System.out.println("--- Mətn Massivi Testi ---");
        String[] sozler = {"Mercedes", "BMW", "Audi", "Toyota"};
        System.out.println("Dəyişmədən əvvəl: " + Arrays.toString(sozler));

        // 0-cı indeks ("Mercedes") ilə 2-ci indeksin ("Audi") yerini dəyişək
        elementlerinYeriniDeyis(sozler, 0, 2);

        System.out.println("Dəyişmədən sonra:  " + Arrays.toString(sozler));
        System.out.println("---------------------------\n");


        // --- Double (Onluq kəsr) massivi ilə test ---
        System.out.println("--- Onluq Kəsr Massivi Testi ---");
        Double[] kesrler = {3.14, 9.81, 1.61, 2.71};
        System.out.println("Dəyişmədən əvvəl: " + Arrays.toString(kesrler));

        // 0-cı indeks ilə 3-cü indeksin yerini dəyişək
        elementlerinYeriniDeyis(kesrler, 0, 3);

        System.out.println("Dəyişmədən sonra:  " + Arrays.toString(kesrler));
        System.out.println("--------------------------------\n");

        // --- Səhv indeks ilə test ---
        System.out.println("--- Səhv İndeks Testi ---");
        elementlerinYeriniDeyis(reqemler, 0, 99); // 99-cu indeks mövcud deyil
    }
}