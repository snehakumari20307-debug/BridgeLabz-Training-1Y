package com.gla.library.members;

public class Member {

        private int memberId;
        private String name;

        public Member(int memberId, String name) {
            this.memberId = memberId;
            this.name = name;
        }

        public void displayMember() {
            System.out.println("Member ID: " + memberId +
                    ", Name: " + name);
        }

        public int getMemberId() {
            return memberId;
        }

        public String getName() {
            return name;
        }
    }

