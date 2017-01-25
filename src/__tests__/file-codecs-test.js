import {encode8, encode16, encode32, decode8, decode16, decode32} from '../file-codecs';

describe('File encoding tests', () => {
    const THE_TEST_STRING = 'The quick brown fox jumps over the lazy dog.';

    it ('encode and decode must be compatible for 8 bits', () => {
        expect(decode8(encode8(THE_TEST_STRING))).toBe(THE_TEST_STRING);
    });

    it ('encode and decode must be compatible for 16 bits', () => {
        expect(decode16(encode16(THE_TEST_STRING))).toBe(THE_TEST_STRING);
    });

    it ('encode and decode must be compatible for 32 bits', () => {
        expect(decode32(encode32(THE_TEST_STRING))).toBe(THE_TEST_STRING);
    });
});
