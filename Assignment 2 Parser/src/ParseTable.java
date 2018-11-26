
import java.util.HashMap;

public class ParseTable {

    private HashMap<String, Integer> n_terms;
    private HashMap<String, Integer> terms;
	
    private int[][] table;
    private RuleList rules;

    public ParseTable() {
        fill_HashMaps();
        fillTable();
		
        rules = new RuleList();
    }

    public Rule get(String top, String front) {
		
        int left_ID = n_terms.get(top);
        int right_ID = terms.get(front);

        int rule_ID = lookup(left_ID, right_ID);
		
        if (rule_ID == 0) 
            return null;
		else 
            return rules.get(rule_ID);
    }

    private int lookup(int left_ID, int right_ID) {
        return table[left_ID][right_ID];
    }

    private void fillTable() {
		
        // [row][column]
        table = new int[29][30];
        table[0][0] = 1;
        table[1][1] = 2;
        table[2][2] = 4;
        table[2][3] = 3;
        table[2][7] = 4;
        table[2][9] = 4;
        table[2][10] = 4;
        table[3][4] = 5;
        table[4][5] = 7;
        table[4][15] = 6;
        table[4][16] = 6;
        table[4][17] = 6;
        table[5][15] = 8;
        table[5][16] = 8;
        table[5][17] = 8;
        table[6][15] = 9;
        table[6][16] = 10;
        table[6][17] = 11;
        table[7][7] = 12;
        table[8][2] = 14;
        table[8][7] = 13;
        table[8][9] = 13;
        table[8][10] = 13;
        table[9][7] = 15;
        table[9][9] = 16;
        table[9][10] = 17;
        table[10][7] = 18;
        table[11][9] = 19;
        table[12][10] = 20;
        table[13][4] = 21;
        table[14][4] = 22;
        table[15][4] = 23;
        table[15][7] = 23;
        table[15][12] = 23;
        table[15][13] = 23;
        table[15][14] = 23;
        table[16][5] = 25;
        table[16][11] = 24;
        table[17][4] = 28;
        table[17][7] = 28;
        table[17][12] = 28;
        table[17][13] = 28;
        table[17][14] = 28;
        table[18][5] = 27;
        table[18][6] = 27;
        table[18][11] = 27;
        table[18][18] = 26;
        table[18][19] = 26;
        table[18][20] = 26;
        table[18][21] = 26;
        table[18][22] = 26;
        table[18][23] = 26;
        table[19][4] = 31;
        table[19][7] = 31;
        table[19][12] = 31;
        table[19][13] = 31;
        table[19][14] = 31;
        table[20][5] = 30;
        table[20][6] = 30;
        table[20][11] = 30;
        table[20][18] = 30;
        table[20][19] = 30;
        table[20][20] = 30;
        table[20][21] = 30;
        table[20][22] = 30;
        table[20][23] = 30;
        table[20][24] = 29;
        table[20][25] = 29;
        table[21][4] = 34;
        table[21][7] = 34;
        table[21][12] = 34;
        table[21][13] = 34;
        table[21][14] = 34;
        table[22][5] = 33;
        table[22][6] = 33;
        table[22][11] = 33;
        table[22][18] = 33;
        table[22][19] = 33;
        table[22][20] = 33;
        table[22][21] = 33;
        table[22][22] = 33;
        table[22][23] = 33;
        table[22][24] = 33;
        table[22][25] = 33;
        table[22][26] = 32;
        table[22][27] = 32;
        table[22][28] = 32;
        table[23][4] = 39;
        table[23][7] = 38;
        table[23][12] = 35;
        table[23][13] = 36;
        table[23][14] = 37;
        table[24][18] = 40;
        table[24][19] = 41;
        table[24][20] = 43;
        table[24][21] = 44;
        table[24][22] = 42;
        table[24][23] = 45;
        table[25][22] = 46;
        table[26][23] = 47;
        table[27][24] = 48;
        table[27][25] = 49;
        table[28][26] = 50;
        table[28][27] = 51;
        table[28][28] = 52;
    }

    private void fill_HashMaps() {
		
        n_terms = new HashMap<>();
        n_terms.put("Pgm", 0);
        n_terms.put("Main", 1);
        n_terms.put("BBlock", 2);
		
        n_terms.put("Vargroup", 3);
        n_terms.put("PPVarlist", 4);
        n_terms.put("Varlist", 5);
        n_terms.put("Varitem", 6);
        n_terms.put("Vardecl", 7);
        n_terms.put("Simplekind", 8);
        n_terms.put("Basekind", 9);
        n_terms.put("Classid", 10);
        n_terms.put("Varspec", 11);
        n_terms.put("Varid", 12);
        n_terms.put("Arrspec", 13);
        n_terms.put("KKint", 14);
        n_terms.put("Deref_id", 15);
        n_terms.put("Deref", 16);
		
        n_terms.put("Varinit", 17);
        n_terms.put("BBexprs", 18);
        n_terms.put("Exprlist", 19);
        n_terms.put("Moreexprs", 20);
		
        n_terms.put("Classdecl", 21);
        n_terms.put("Classdef", 22);
        n_terms.put("BBClassitems", 23);
        n_terms.put("Classheader", 24);
        n_terms.put("Classmom", 25);
        n_terms.put("Classitems", 26);
        n_terms.put("Classgroup", 27);
        n_terms.put("Class_ctrl", 28);
		n_terms.put("Interfaces", 29);
		
		n_terms.put("Mddecls", 30);
		n_terms.put("Mdheader", 31);
		n_terms.put("Md_id", 32);
		
		n_terms.put("Fcndefs", 33);
		n_terms.put("Fcndef", 34);
		
		n_terms.put("Fcnheader", 35);
		n_terms.put("Fcnid", 36);
		n_terms.put("Retkind", 37);
		n_terms.put("PParmlist", 38);
		n_terms.put("Varspecs", 39);
		n_terms.put("More_varspecs", 40);
		n_terms.put("PPonly", 41);
		
		n_terms.put("Stmts", 42);
		n_terms.put("Stmt", 43);
		
		n_terms.put("Stasgn", 44);
		n_terms.put("Lval", 45);
		n_terms.put("Aref", 46);
		n_terms.put("KKexpr", 47);
		
		n_terms.put("Fcall", 48);
		n_terms.put("PPexpr", 49);
		
		n_terms.put("Stif", 50);
		n_terms.put("Elsepart", 51);
		
		n_terms.put("Stwhile", 52);
		n_terms.put("Stprint", 53);
		
		n_terms.put("Strtn", 54);
		
		n_terms.put("Expr", 55);
		n_terms.put("Rterm", 56);
		n_terms.put("Term", 57);
		n_terms.put("Fact", 58);
		n_terms.put("Addrof_id", 59);
		n_terms.put("Oprel", 60);
		n_terms.put("Lthan", 61);
		n_terms.put("Gthan", 62);
		n_terms.put("Opadd", 63);
		n_terms.put("Opmul", 64);
		

        // terms = terminal symbol mapper to int for array lookup
        terms = new HashMap<>();
        terms.put("kwdprog", 0);
        terms.put("kwdmain", 1);
        terms.put("brace1", 2);
        terms.put("brace2", 3);
        terms.put("kwdvars", 4);
        terms.put("parens1", 5);
        terms.put("parens2", 6);
        terms.put("semi", 7);
        terms.put("equal", 8);
        terms.put("int", 9);
        terms.put("float", 10);
        terms.put("string", 11);
        terms.put("id", 12);
        terms.put("bracket1", 13);
        terms.put("bracket2", 14);
        terms.put("aster", 15);
        terms.put("comma", 16);
        terms.put("colon", 17);
        terms.put("public", 18);
        terms.put("protected", 19);
        terms.put("private", 20);
        terms.put("kwdfcn", 21);
        terms.put("kind", 22);
        terms.put("kwdif", 23);
        terms.put("kwdelseif", 24);
        terms.put("kwdelse", 25);
        terms.put("kwdwhile", 26);
        terms.put("kdprint", 27);
        terms.put("kwdreturn", 28);
		terms.put("ampersand", 29);
		terms.put("opeq", 30);
		terms.put("opne", 31);
		terms.put("ople", 32);
		terms.put("opge", 33);
		terms.put("angle1", 34);
		terms.put("angle2", 35);
		terms.put("plus", 36);
		terms.put("minus", 37);
		terms.put("slash", 38);
		terms.put("caret", 39);
		
        terms.put("eps", 40);
    }
}
