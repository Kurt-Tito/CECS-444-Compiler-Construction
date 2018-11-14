// This class the list of rule given from the A6 Grammar Appendix
public class RuleList {

    private Rule[] rules;
    //number of rules
    private final int NUM_RULES = 115;

    /**
     * Default constructor that fills the list.
     */
    public RuleList() {
        fillList();
    }
    //returns the grammar rule and its RHS from the A6 Grammar
    public Rule get(int ruleId) {
        if (ruleId > NUM_RULES + 1 || ruleId < 1) {
            return null;
        }
        //rule with matching rule id returned
        return rules[ruleId - 1];
    }
    //2D array with rules from the Appendix A6 Grammar

    private void fillList() {
        rules = new Rule[NUM_RULES];

        rules[0] = new Rule(1, "Pgm", "kwdprog Vargroup Fendefs Main");
        rules[1] = new Rule(2, "BBlock", "brace1 Vargroup Stmts brace2");
        rules[2] = new Rule(3, "Main", "kwdmain BBlock");
        rules[3] = new Rule(4, "Vargroup", "kwdvars PPvarlist");
        rules[4] = new Rule(5, "Vargroup", "eps");
        rules[5] = new Rule(6, "PPvarlist", "parens1 Varlist parens2");
        rules[6] = new Rule(7, "Varlist", "Varitem semi Varlist");
        rules[7] = new Rule(8, "Varlist", "eps");
        rules[8] = new Rule(9, "Varitem", "Vardecl");
        rules[9] = new Rule(10, "Varitem", "Vardecl equal Varinit");
        rules[10] = new Rule(11, "Varitem", "Classdecl");
        rules[11] = new Rule(12, "Varitem", "Classdef");
        rules[12] = new Rule(13, "Vardecl", "Simplekind Varspec");
        rules[13] = new Rule(14, "Simplekind", "Basekind");
        rules[14] = new Rule(15, "Simplekind", "Classid");
        rules[15] = new Rule(16, "Basekind", "int");
        rules[16] = new Rule(17, "Basekind", "float");
        rules[17] = new Rule(18, "Basekind", "string");
        rules[18] = new Rule(19, "Classid", "id");
        rules[19] = new Rule(20, "Varspec", "Varid");
        rules[20] = new Rule(21, "Varspec", "Arrspec");
        rules[21] = new Rule(22, "Varspec", "Deref_id");
        rules[22] = new Rule(23, "Varid","id");
        rules[23] = new Rule(24, "Arrspec", "Varid KKint");
        rules[24] = new Rule(25, "KKint", "bracket1 int bracket2");
        rules[25] = new Rule(26, "Deref_id", "Deref id");
        rules[26] = new Rule(27, "Deref", "aster");
        rules[27] = new Rule(28, "Varinit", "Expr");
        rules[28] = new Rule(29, "Varinit", "BBexprs");
        rules[29] = new Rule(30, "BBexprs", "brace1 Exprlist brace2");
        rules[30] = new Rule(31, "BBexprs", "brace1 brace2");
        rules[31] = new Rule(32, "Exprlist", "Expr Moreexprs");
        rules[32] = new Rule(33, "Moreexprs", "comma Exprlist");
        rules[33] = new Rule(34, "Moreexprs", "eps");
        rules[34] = new Rule(35, "Classdecl", "kwdclass Classid");
        rules[35] = new Rule(36, "Classdef", "Classheader BBclassitems");
        rules[36] = new Rule(37, "BBclassitems", "brace1 Classitems brace2");
        rules[37] = new Rule(38, "Classheader", "Classdecl Classmom Interfaces");
        rules[38] = new Rule(39, "Classmom", "colon Classid");
        rules[39] = new Rule(40, "Classmom", "eps");
        rules[40] = new Rule(41, "Classitems", "Classgroup Classitems");
        rules[41] = new Rule(42, "Classitems", "eps");
        rules[42] = new Rule(43, "Classgroup", "Class_ctrl");
        rules[43] = new Rule(44, "Classgroup", "Varlist");
        rules[44] = new Rule(45, "Classgroup", "Mddecls");
        rules[45] = new Rule(46, "Class_ctrl", "colon id");
        rules[46] = new Rule(47, "Interfaces", "colon Classid Interfaces");
        rules[47] = new Rule(48, "Interfaces", "eps");
        rules[48] = new Rule(49, "Mddecls", "Mdheader Mddecls");
        rules[49] = new Rule(50, "Mddecls", "eps");
        rules[50] = new Rule(51, "Mdheader", "kwdfcn Md_id PParmlist Retkind");
        rules[51] = new Rule(52, "Md_id", "Classid colon Fenid");
        rules[52] = new Rule(53, "Fendefs", "Fendef Fendefs");
        rules[53] = new Rule(54, "Fendefs", "eps");
        rules[54] = new Rule(55, "Fendef", "Fenheader BBlock");
        rules[55] = new Rule(56, "Fenheader", "kwdfen Fenid PParmlist Retkind");
        rules[56] = new Rule(57, "Fenid", "id");
        rules[57] = new Rule(58, "Retkind", "Kind");
        rules[58] = new Rule(59, "PParmlist", "parens1 Varspecs parens2");
        rules[59] = new Rule(60, "PParmlist", "PPonly");
        rules[60] = new Rule(61, "Varspecs", "Varspec More_varspecs");
        rules[61] = new Rule(62, "More_varspecs", "comma Varspecs");
        rules[62] = new Rule(63, "More_varspecs", "eps");
        rules[63] = new Rule(64, "PPonly", "parens1 parens2");
        rules[64] = new Rule(65, "Stmts", "Stmt semi Stmts");
        rules[65] = new Rule(66, "Stmts", "eps");
        rules[66] = new Rule(67, "Stmt", "Stasgn");
        rules[67] = new Rule(68, "Stmt", "Fcall");
        rules[68] = new Rule(69, "Stmt", "Stif");
        rules[69] = new Rule(70, "Stmt", "Stwhile");
        rules[70] = new Rule(71, "Stmt", "Stprint");
        rules[71] = new Rule(72, "Stmt", "Strtn");
        rules[72] = new Rule(73, "Stasgn", "Lval equal Expr");
        rules[73] = new Rule(74, "Lval", "Varid");
        rules[74] = new Rule(75, "Lval","Aref");
        rules[75] = new Rule(76, "Lval", "Deref_id");
        rules[76] = new Rule(77, "Aref", "Varid KKexpr");
        rules[77] = new Rule(78, "KKexpr", "bracket1 Expr bracket2");
        rules[78] = new Rule(79, "Fcall", "Fcnid PPexprs");
        rules[79] = new Rule(80, "PPexprs", "parens1 Exprlist parens2");
        rules[80] = new Rule(81, "PPexprs", "PPonly");
        rules[81] = new Rule(82, "Stif", "kwdif PPexpr BBlock Elsepart");
        rules[82] = new Rule(83, "Elsepart", "kwdelseif PPexpr BBlock Elsepart");
        rules[83] = new Rule(84, "Elsepart", "kwdelse BBlock");
        rules[84] = new Rule(85, "Elsepart", "eps");
        rules[85] = new Rule(86, "Stwhile", "kwdwhile PPexpr BBlock");
        rules[86] = new Rule(87, "Stprint", "kprint PPexprs");
        rules[87] = new Rule(88, "Strtn", "kwdreturn Expr");
        rules[88] = new Rule(89, "Strtn", "kwdreturn");
        rules[89] = new Rule(90, "PPexpr", "parens1 Expr parens2");
        rules[90] = new Rule(91, "Expr", "Expr Oprel Rterm");
        rules[91] = new Rule(92, "Expr", "Rterm");
        rules[92] = new Rule(93, "Rterm", "Rterm Opadd Term");
        rules[93] = new Rule(94, "Rterm", "Term");
        rules[94] = new Rule(95, "Term", "Term Opmul Fact");
        rules[95] = new Rule(96, "Term", "Fact");
        rules[96] = new Rule(97, "Fact", "Basekind");
        rules[97] = new Rule(98, "Fact", "Lval");
        rules[98] = new Rule(99, "Fact", "Addrof_id");
        rules[99] = new Rule(100, "Fact", "Fcall");
        rules[100] = new Rule(101, "Fact", "PPexpr");
        rules[101] = new Rule(102, "Addrof_id", "ampersand id");
        rules[102] = new Rule(103, "Oprel", "opeq");
        rules[103] = new Rule(104, "Oprel", "opne");
        rules[104] = new Rule(105, "Oprel", "Lthan");
        rules[105] = new Rule(106, "Oprel", "ople");
        rules[106] = new Rule(107, "Oprel", "opge");
        rules[107] = new Rule(108, "Oprel", "Gthan");
        rules[108] = new Rule(109, "Lthan", "angle1");
        rules[109] = new Rule(110, "Gthan", "angle2");
        rules[110] = new Rule(111, "Opadd", "plus");
        rules[111] = new Rule(112, "Opadd", "minus");
        rules[112] = new Rule(113, "Opmul", "aster");
        rules[113] = new Rule(114, "Opmul", "slash");
        rules[114] = new Rule(115, "Opmul", "caret");

    }
}