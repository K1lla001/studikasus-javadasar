import java.util.Scanner;

public class TodoList {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] data = new String[5];

    public static void main(String[] args) {

        menu();

    }
    public static String input(String input){
        System.out.print(input);
        var inputs = scanner.nextLine();
        return inputs;
    }

    //Menu todo list
    public static void menu(){
        while (true){
            System.out.println("TODO LIST SEDERHANA");

            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah todo");
            System.out.println("2. Hapus todo");
            System.out.println("x. Keluar");
            var inputMenu = input("Masukkan Pilihan : ");
            if(inputMenu.equals("1")){
                viewAddTodoList();
            }else if (inputMenu.equals("2")){
                viewRemoveTodoList();
            } else if (inputMenu.equals("x")){
                break;
            } else {
                System.out.println("Menu tidak ada, Masukkan menu yang tersedia");
            }
        }

    }
    //Menampilkan todo list
    public static void showTodoList(){
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null){
                System.out.println((i+1) + ". " + data[i]);
            }
        }
    }

    //menambah todo list
    public static void addTodo(String todo){
        //bagaimana jika list full?
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null){
                isFull = false;
            }
        }
        if(isFull){
            //menampung data lama
            var temp = data;
            //resize list
            data = new String[data.length * 2];

            //masukkan data lama ke data baru
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        //menambahkan todo ke list
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null){
                data[i] = todo;
                break;
            }
        }
    }
    //Menampilkan view add todo
    public static void viewAddTodoList(){
        var input = input("Masukkan Todo List (x untuk membatalkan) : ");
        if(input.equals("x") || input.isBlank() || input.isEmpty()){
            menu();
        } else {
            addTodo(input);
        }
    }
    public static Boolean removeTodoList(int todo){
        if((todo - 1) >= data.length){
            return false;
        }
        if(data[todo - 1] == null){
            return false;
        }

        for (int i = (todo - 1); i < data.length; i++) {
            if(i == (data.length - 1)){
                data[i] = null;
            } else {
                data[i] = data[i + 1];
            }
        }
        return true;
    }
    public static void viewRemoveTodoList(){
        var inputRemove = input("Masukkan Angka List yang ingin dihapus (x untuk membatalkan) : ");
        if(inputRemove.equals("x")){
            menu();
        } else {
            var success = removeTodoList(Integer.valueOf(inputRemove));
            if(!success){
                System.out.println("Gagal menghapus todo list!");
            }
        }
    }
    //test add todo
    static void testAddTodo(){
        addTodo("Ari");
        addTodo("Susanto");
        addTodo("Karawang");
        addTodo("Indonesia");
    }
    //test view todo list
    static void testViewTodoList(){
        testAddTodo();

        showTodoList();
    }
    //test view add todo list
    static void testViewAddTodoList(){
        menu();
    }
    static void testRemoveTodoList(){
        addTodo("Ari");
        addTodo("Susanto");
        addTodo("Karawang");
        addTodo("Indonesia");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }

    static void testViewRemoveTodoList(){
        addTodo("Ari");
        addTodo("Susanto");
        addTodo("Karawang");
        addTodo("Indonesia");

        showTodoList();

        viewRemoveTodoList();
    }
}


