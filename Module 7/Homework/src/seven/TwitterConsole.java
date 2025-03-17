package seven;
import java.util.*;
import java.util.stream.Collectors;

public class TwitterConsole {
    private static final List<Post> posts = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();
        currentUser = new User(userName);

        System.out.println("Добро пожаловать, " + currentUser.getName() + "!");
        initializePosts();

        while (true) {
            System.out.println("\n=== Twitter Console ===");
            System.out.println("1. Написать пост");
            System.out.println("2. Лайкнуть пост");
            System.out.println("3. Сделать репост");
            System.out.println("4. Показать все посты");
            System.out.println("5. Показать популярные посты");
            System.out.println("6. Показать мои посты");
            System.out.println("7. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Поглощение новой строки

            switch (choice) {
                case 1 -> createPost(scanner);
                case 2 -> likePost(scanner);
                case 3 -> repostPost(scanner);
                case 4 -> showAllPosts();
                case 5 -> showPopularPosts(scanner);
                case 6 -> showMyPosts();
                case 7 -> {
                    System.out.println("Выход. До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void initializePosts() {
        posts.add(new Post(new User("Alice"), "Привет, мир!"));
        posts.add(new Post(new User("Bob"), "Сегодня отличный день!"));
        posts.add(new Post(new User("Charlie"), "Люблю программировать на Java."));
        System.out.println("Добавлены стартовые посты.");
    }

    private static void createPost(Scanner scanner) {
        System.out.print("Введите текст поста (макс. 280 символов): ");
        String content = scanner.nextLine();

        if (content.length() > 280) {
            System.out.println("Ошибка: текст поста превышает 280 символов.");
        } else {
            posts.add(new Post(currentUser, content));
            System.out.println("Пост добавлен!");
        }
    }

    private static void likePost(Scanner scanner) {
        System.out.print("Введите ID поста для лайка: ");
        int id = scanner.nextInt();

        posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        Post::like,
                        () -> System.out.println("Пост с таким ID не найден.")
                );
    }

    private static void repostPost(Scanner scanner) {
        System.out.print("Введите ID поста для репоста: ");
        int id = scanner.nextInt();

        posts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        post -> {
                            posts.add(new Post(currentUser, "Repost: " + post.getContent()));
                            post.repost();
                            System.out.println("Репост успешно выполнен!");
                        },
                        () -> System.out.println("Пост с таким ID не найден.")
                );
    }

    private static void showAllPosts() {
        posts.stream()
                .sorted(Comparator.comparing(Post::getCreationDate).reversed())
                .forEach(System.out::println);
    }

    private static void showPopularPosts(Scanner scanner) {
        System.out.print("Введите количество популярных постов для отображения: ");
        int count = scanner.nextInt();

        posts.stream()
                .sorted(Comparator.comparing(Post::getLikes).reversed())
                .limit(count)
                .forEach(System.out::println);
    }

    private static void showMyPosts() {
        posts.stream()
                .filter(post -> post.getAuthor().equals(currentUser))
                .forEach(System.out::println);
    }
}

