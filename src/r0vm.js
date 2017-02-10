const REG = [
        'R0', 'R1', 'R2', 'R3', 'R4', 'R5', 'R6', 'R7',
        'R8', 'R9', 'RA', 'RB', 'RC', 'RD', 'RE', 'RF'
    ],
    MNEMO = [
        'MOV',  'MVN',  'ADD',  'SUB',  'MUL',  'DIV',  'MOD',  'CMP',
        'MOVI', 'MVNI', 'ADDI', 'SUBI', 'MULI', 'DIVI', 'MODI', 'CMPI',
        'CHKI',
        'LDW',  'LDB',  'POP',
        'STW',  'STB',  'PUSH',
        'RD', 'WRD', 'WRH', 'WRL',
        'BEQ', 'BNE', 'BLT', 'BGE', 'BLE', 'BGT', 'BR', 'BSR', 'RET'
    ];

let bitCuts = function (num, hi, lo) {
    let mask = 1;
    while (hi-- > lo) { mask = mask << 1 | 1; }
    return (num >>> lo) & mask;
};

let cmdToStr = function (cmd) {
    switch (cmd.type) {
        case 0:
        case 1:
        case 2:
        case 3:
        default: return 'Unknown CMD'
    }
    return null;
};

let toCommand = function (num) {
    let cmd = {
        type: bitCuts(num, 31, 30),
        op: bitCuts(num, 29, 26)
    };
    if (cmd.type == 3) {
        cmd.disp = num & 0x03ffffff;
    } else {
        cmd.a = bitCuts(num, 25, 22);
        cmd.b = bitCuts(num, 21, 18);
        if (cmd.type == 0) {
            cmd.c = bitCuts(num, 3, 0);
        } else {
            cmd[cmd.type == 1 ? 'im' : 'disp'] = bitCuts(bnum, 17, 0);
        }
    }
    return cmd;
};

export default class R0vm {
    constructor (o) {
        this._regs = {}
        this._mem = new Uint32Array(o.memSze || 16 * 1024);
    }
    exec () {}
    load (arr = [], org = 0) {
        for (let i = 0, len = arr.length; i < len; ++i) {
            this._mem[org + i] = arr[i];
        }
    }
}
