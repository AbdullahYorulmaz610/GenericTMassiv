import java.util.Arrays;

public class Main {

    /**
     * Bu generic metod istənilən tipdə olan massivdə iki elementin yerini dəyişir.
     * Düzgün olmayan indekslər daxil edildikdə xəta atır (throws exception).
     *
     * @param massiv Üzərində əməliyyat aparılacaq massiv.
     * @param index1 Dəyişdiriləcək birinci elementin indeksi.
     * @param index2 Dəyişdiriləcək ikinci elementin indeksi.
     * @param <T>    Massivin elementlərinin tipi.
     * @throws IndexOutOfBoundsException Əgər daxil edilən indekslər massivin hüdudlarından kənarda olarsa.
     * @throws IllegalArgumentException Əgər massiv 'null' olarsa.
     */
    public static <T> void elementlerinYeriniDeyis(T[] massiv, int index1, int index2)
            throws IndexOutOfBoundsException, IllegalArgumentException {

        // 1. Massivin null olub-olmadığını yoxlayırıq
        if (massiv == null) {
            throw new IllegalArgumentException("Xəta: Massiv 'null' ola bilməz.");
        }

        // 2. İndekslərin massivin hüdudları daxilində olub-olmadığını yoxlayırıq
        if (index1 < 0 || index1 >= massiv.length || index2 < 0 || index2 >= massiv.length) {
            // Əgər şərt ödənsə, proqramın işini dayandırıb xəta atırıq.
            throw new IndexOutOfBoundsException(
                    "Xəta: Daxil edilən indekslər (" + index1 + ", " + index2 + ") " +
                            "massivin hüdudlarından (0-" + (massiv.length - 1) + ") kənardadır."
            );
        }

        // Əgər yuxarıdakı yoxlamalardan heç biri xəta atmazsa, yer dəyişməni icra edirik.
        T muveqqetiElement = massiv[index1];
        massiv[index1] = massiv[index2];
        massiv[index2] = muveqqetiElement;
    }

    public static void main(String[] args) {
        // --- Uğurlu test nümunəsi ---
        System.out.println("--- Uğurlu Test ---");
        String[] sozler = {"Mercedes", "BMW", "Audi", "Toyota"};
        System.out.println("Dəyişmədən əvvəl: " + Arrays.toString(sozler));

        try {
            elementlerinYeriniDeyis(sozler, 1, 3); // Düzgün indekslər
            System.out.println("Dəyişmədən sonra:  " + Arrays.toString(sozler));
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Gözlənilməz xəta baş verdi: " + e.getMessage());
        }
        System.out.println("--------------------\n");


        // --- Xətalı test nümunəsi (handle etmək) ---
        System.out.println("--- Xətalı İndeks Testi ---");
        Integer[] reqemler = {10, 20, 30, 40, 50}; // Massivin 5 elementi var (indekslər 0-4)
        System.out.println("Massiv: " + Arrays.toString(reqemler));

        // Xəta yarada biləcək metodu 'try-catch' bloku daxilində çağırırıq
        try {
            // 10-cu indeks mövcud olmadığı üçün bu sətir xəta atacaq
            elementlerinYeriniDeyis(reqemler, 1, 10);

            // Bu sətir heç vaxt icra olunmayacaq, çünki yuxarıda xəta baş verəcək
            System.out.println("Dəyişmə uğurla başa çatdı.");
        } catch (IndexOutOfBoundsException e) {
            // Metodun atdığı xətanı burada tuturuq və mesajını çap edirik
            System.out.println("Xəta tutuldu: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Xəta tutuldu: " + e.getMessage());
        } finally {
            // Bu blok xəta olsa da, olmasa da hər zaman icra olunur
            System.out.println("Test əməliyyatı bitdi.");
        }
        System.out.println("--------------------------");
    }
}