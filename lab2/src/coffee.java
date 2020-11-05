public class coffee {
    float mass;
    float count;
    Grade grade;
    form form;


    coffee(float mass,float count, Grade grade, form form){
        this.count = count;
        this.mass = mass;
        this.grade = grade;
        this.form = form;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
