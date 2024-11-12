package ru.nsu.odnostorontseva.substringfinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<Character, TrieNode> goCache = new HashMap<>();
        TrieNode link = null;
        TrieNode parent;
        char parentChar;

        TrieNode(char parentChar, TrieNode parent) {
            this.parentChar = parentChar;
            this.parent = parent;
        }
    }

    private final TrieNode root = new TrieNode('\0', null);
    private String pattern;

    public void addPattern(String pattern) {
        TrieNode node = root;
        for (char c : pattern.toCharArray()) {
            TrieNode finalNode = node;
            node = node.children.computeIfAbsent(c, k -> new TrieNode(c, finalNode));
        }
        this.pattern = pattern;
    }

    private TrieNode getLink(TrieNode node) {
        if (node.link == null) {
            if (node == root || node.parent == root) {
                node.link = root;
            } else {
                node.link = go(getLink(node.parent), node.parentChar);
            }
        }
        return node.link;
    }

    private TrieNode go(TrieNode node, char c) {
        if (!node.goCache.containsKey(c)) { // Если переход по символу `c` ещё не вычислен
            if (node.children.containsKey(c)) {
                node.goCache.put(c, node.children.get(c)); // Прямой переход
            } else if (node == root) {
                node.goCache.put(c, root); // Из корня переход на самого себя
            } else {
                node.goCache.put(c, go(getLink(node), c)); // Иначе переход по суффиксной ссылке
            }
        }
        return node.goCache.get(c);
    }

    public List<Integer> search(String text) {
        List<Integer> results = new ArrayList<>();
        TrieNode node = root;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            node = go(node, c); // Используем ленивый переход

            char endOfPat = pattern.charAt(pattern.length() - 1);

            if (node.parentChar == endOfPat) {
                results.add(i - pattern.length() + 1);
            }
        }
        return results;
    }
}
