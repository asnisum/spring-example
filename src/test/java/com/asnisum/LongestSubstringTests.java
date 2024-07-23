package com.asnisum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LongestSubstringTests {

	@Test
	void test() {
		String case1 = "abcabcbb";
		int result1 = solution(case1);
		// Explanation: The answer is "abc", with the length of 3.
		assertEquals(3, result1);

		String case2 = "bbbbbb";
		int result2 = solution(case2);
		// Explanation: The answer is "b", with the length of 1.
		assertEquals(1, result2);

		String case3 = "pwwkew";
		int result3 = solution(case3);
		// Explanation: The answer is "wke", with the length of 3.
		// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		assertEquals(3, result3);

		String case4 = " ";
		int result4 = solution(case4);
		// Explanation: The answer is "wke", with the length of 3.
		// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		assertEquals(1, result4);

		String case5 = "au";
		int result5 = solution(case5);
		// Explanation: The answer is "wke", with the length of 3.
		// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		assertEquals(2, result5);
	}

	private int solution(String str) {
		int count = 0;
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				boolean add = set.add((int) str.charAt(j));
				count = Math.max(count, set.size());
				if (count >= str.length() - i) {
					return count;
				}

				if (!add) {
					set.clear();
					break;
				}
			}
		}

		return count;
	}
}
