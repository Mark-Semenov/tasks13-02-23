package ru.gb.mark.builder;

import ru.gb.mark.builder.entity.Person;

public class PersonBuilder {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final Person person;

        public Builder() {
            person = new Person();
        }

        public Builder setFirstName(String firstName) {
            this.person.setFirstName(firstName);
            return this;
        }

        public Builder setLastName(String lastName) {
            this.person.setLastName(lastName);
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.person.setMiddleName(middleName);
            return this;
        }

        public Builder setCountry(String country) {
            this.person.setCountry(country);
            return this;
        }

        public Builder setAddress(String address) {
            this.person.setAddress(address);
            return this;
        }

        public Builder setPhone(String phone) {
            this.person.setPhone(phone);
            return this;
        }

        public Builder setAge(int age) {
            this.person.setAge(age);
            return this;
        }

        public Builder setGender(String gender) {
            this.person.setGender(gender);
            return this;
        }

        public Person build() {
            return this.person;
        }

    }
}
