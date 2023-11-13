package com.std.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private  int i;
    HomeController() {
        i = -1;
    }
    @GetMapping("/home/main")
    @ResponseBody
    public String ShowMain() {
        return "안녕하세요";
    }

    @GetMapping("/home/main2")
    @ResponseBody
    public String ShowMain2() {
        return "반갑습니다";
    }

    @GetMapping("/home/main3")
    @ResponseBody
    public String ShowMain3() {
        return "즐거웠습니다";
    }

    @GetMapping("/home/increase")
    @ResponseBody
    public int ShowMain4() {
        i++;
        return i;
    }

    @GetMapping("/home/plus")
    @ResponseBody
    public int ShowMain5(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/home/minus")
    @ResponseBody
    public int ShowMain6(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return a - b;
    }
    @GetMapping("/home/multiply")
    @ResponseBody
    public int ShowMain7(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return a * b;
    }
    @GetMapping("/home/divide")
    @ResponseBody
    public int ShowMain8(@RequestParam(defaultValue = "0") int a, @RequestParam int b) {
        return a / b;
    }

    @GetMapping("/home/bln")
    @ResponseBody
    public boolean ShowMain8() {
        return true;
    }

    @GetMapping("/home/PI")
    @ResponseBody
    public double ShowMain9() {
        return Math.PI;
    }

    @GetMapping("/home/array")
    @ResponseBody
    public int[] ShowMain10() {
        int[] i= {1,2,3,4};
        return i;
    }

    @GetMapping("/home/list")
    @ResponseBody
    public List<Integer> ShowMain11() {
        List<Integer> i = new ArrayList<>(){{
            add(2);
            add(3);
        }};
        return i;
    }
    @GetMapping("/home/returnCarMapList")
    @ResponseBody
    public List<Map<String, Object>> ShowMain12() {
        Map<String, Object> carMap1 = new LinkedHashMap<>() {{
            put("id", 1);
            put("speed", 100);
            put("name", "카니발");
            put("relatedIds", new ArrayList<>() {{
                add(2);
                add(3);
                add(4);
            }});
        }};

        Map<String, Object> carMap2 = new LinkedHashMap<>() {{
            put("id", 2);
            put("speed", 200);
            put("name", "포르쉐");
            put("relatedIds", new ArrayList<>() {{
                add(5);
                add(6);
                add(7);
            }});
        }};

        List<Map<String, Object>> list = new ArrayList<>();

        list.add(carMap1);
        list.add(carMap2);

        return list;
    }

    @GetMapping("/home/returnCarList")
    @ResponseBody
    public List<CarV2> ShowMain13() {
        CarV2 car1 = new CarV2(1, 100, "카니발", new ArrayList<>() {{
            add(2);
            add(3);
            add(4);
        }});

        CarV2 car2 = new CarV2(2, 200, "포르쉐", new ArrayList<>() {{
            add(5);
            add(6);
            add(7);
        }});

        List<CarV2> list = new ArrayList<>();

        list.add(car1);
        list.add(car2);

        return list;
    }

    @GetMapping("/home/returnPerson")
    @ResponseBody
    public List<Person> ShowMain14(@RequestParam(defaultValue = "1") int id, @RequestParam String name, @RequestParam int age) {
        List<Person> people = new ArrayList<>();
        id++;

        return people;
    }
}

class Car {
    private final int id;
    private final int speed;
    private final String name;
    private final List<Integer> relatedIds;

    public Car(int id, int speed, String name, List<Integer> relatedIds) {
        this.id = id;
        this.speed = speed;
        this.name = name;
        this.relatedIds = relatedIds;
    }

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRelatedIds() {
        return relatedIds;
    }
}

@Getter
@AllArgsConstructor
class CarV2 {
    private final int id;
    private final int speed;
    private String name;
    private final List<Integer> relatedIds;
}

@Getter
@AllArgsConstructor
class Person {
    private int id;
    private String name;
    private int age;
}