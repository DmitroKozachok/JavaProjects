package org.example;

import org.example.entities.CategoryEntity;
import org.example.utils.HibernateHelper;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== МЕНЮ КАТЕГОРІЙ ===");
            System.out.println("1. Додати категорію");
            System.out.println("2. Переглянути всі категорії");
            System.out.println("3. Оновити категорію");
            System.out.println("4. Видалити категорію");
            System.out.println("0. Вихід");
            System.out.print("Оберіть дію: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть назву категорії: ");
                    String name = sc.nextLine();
                    addCategory(new CategoryEntity(name));
                }

                case 2 -> {
                    System.out.println("\nСписок категорій:");
                    var list = getCategoryList();
                    if (list.isEmpty()) {
                        System.out.println("Категорій немає");
                    } else {
                        list.forEach(System.out::println);
                    }
                }

                case 3 -> {
                    System.out.print("Введіть ID категорії для оновлення: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Введіть нову назву: ");
                    String name = sc.nextLine();
                    var category = new CategoryEntity(name);
                    category.setId(id);
                    updateCategory(category);
                }

                case 4 -> {
                    System.out.print("Введіть ID категорії для видалення: ");
                    int id = sc.nextInt();
                    delCategory(id);
                }

                case 0 -> System.out.println("Вихід з програми...");
                default -> System.out.println("Невірний вибір, спробуйте ще раз.");
            }

        } while (choice != 0);
    }

    public static List<CategoryEntity> getCategoryList() {
        var session = HibernateHelper.getSession();
        try {
            return session.createSelectionQuery("from CategoryEntity", CategoryEntity.class)
                    .getResultList();
        }
        catch (Exception e) {
            System.out.println("Помилка: " + e);
            return List.of();
        }
    }

    public static void addCategory(CategoryEntity category) {
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            session.persist(category);
        });
    }

    public static void delCategory(int id) {
        var sessionFactory = HibernateHelper.getSessionFactory();

        sessionFactory.inTransaction(session -> {
            var category = session.get(CategoryEntity.class, id);

            if (category != null) {
                session.remove(category);
                System.out.println("Категорію видалено: " + category);
            } else {
                System.out.println("Категорію з id=" + id + " не знайдено");
            }
        });
    }

    public static void updateCategory(CategoryEntity category) {
        var sessionFactory = HibernateHelper.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            var newCategory = session.get(CategoryEntity.class, category.getId());

            if (newCategory != null) {
                newCategory.setName(category.getName());
                session.merge(newCategory);
                System.out.println("Оновлена категорія: " + newCategory);
            } else {
                System.out.println("Категорію з id=" + category.getId() + " не знайдено.");
            }
        });
    }
}
