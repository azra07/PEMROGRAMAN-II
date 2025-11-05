package soal1;

public abstract class Shape {
        private String name;

        public Shape(String name) {
            this.name = name;
        }

        public abstract double area();

        public String toString(){
                return name;
            }
    }