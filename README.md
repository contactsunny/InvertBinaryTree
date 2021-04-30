# Invert a binary tree in place

This is a simple Java program to demonstrate how to easily invert a given 
binary tree in place without creating a new binary tree.

---

## Input

The input binary tree is pretty simple. There are nine nodes and it can be
visualized as follows:

```shell script
Given binary tree
1
├──2
│  ├──4
│  │  ├──8
│  │  └──9
│  └──5
└──3
   ├──6
   └──7
--------------------
```

---

## Output

After inversion, the binary tree will look like this:

```shell script
Inverted binary tree
1
├──3
│  ├──7
│  └──6
└──2
   ├──5
   └──4
      ├──9
      └──8
--------------------
```