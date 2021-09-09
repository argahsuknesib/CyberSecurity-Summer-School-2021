package org.libsodium.jni;

public class SodiumJNI {
    public static final native int crypto_aead_chacha20poly1305_abytes();

    public static final native int crypto_aead_chacha20poly1305_decrypt(byte[] bArr, int[] iArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, int i2, byte[] bArr5, byte[] bArr6);

    public static final native int crypto_aead_chacha20poly1305_encrypt(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4, byte[] bArr5, byte[] bArr6);

    public static final native int crypto_aead_chacha20poly1305_ietf_decrypt(byte[] bArr, int[] iArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, int i2, byte[] bArr5, byte[] bArr6);

    public static final native int crypto_aead_chacha20poly1305_ietf_encrypt(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4, byte[] bArr5, byte[] bArr6);

    public static final native int crypto_aead_chacha20poly1305_ietf_npubbytes();

    public static final native int crypto_aead_chacha20poly1305_keybytes();

    public static final native int crypto_aead_chacha20poly1305_npubbytes();

    public static final native int crypto_aead_chacha20poly1305_nsecbytes();

    public static final native int crypto_auth(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_bytes();

    public static final native int crypto_auth_hmacsha256(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_hmacsha256_bytes();

    public static final native int crypto_auth_hmacsha256_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_auth_hmacsha256_init(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_auth_hmacsha256_keybytes();

    public static final native int crypto_auth_hmacsha256_statebytes();

    public static final native int crypto_auth_hmacsha256_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_auth_hmacsha256_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_hmacsha512(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_hmacsha512256(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_hmacsha512256_bytes();

    public static final native int crypto_auth_hmacsha512256_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_auth_hmacsha512256_init(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_auth_hmacsha512256_keybytes();

    public static final native int crypto_auth_hmacsha512256_statebytes();

    public static final native int crypto_auth_hmacsha512256_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_auth_hmacsha512256_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_hmacsha512_bytes();

    public static final native int crypto_auth_hmacsha512_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_auth_hmacsha512_init(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_auth_hmacsha512_keybytes();

    public static final native int crypto_auth_hmacsha512_statebytes();

    public static final native int crypto_auth_hmacsha512_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_auth_hmacsha512_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_auth_keybytes();

    public static final native byte[] crypto_auth_primitive();

    public static final native int crypto_auth_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_box(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_box_beforenm(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_box_beforenmbytes();

    public static final native int crypto_box_boxzerobytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_curve25519xsalsa20poly1305_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_box_curve25519xsalsa20poly1305_beforenm(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_box_curve25519xsalsa20poly1305_beforenmbytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_boxzerobytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_keypair(byte[] bArr, byte[] bArr2);

    public static final native int crypto_box_curve25519xsalsa20poly1305_macbytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_noncebytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_curve25519xsalsa20poly1305_open_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_box_curve25519xsalsa20poly1305_publickeybytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_secretkeybytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_seed_keypair(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_box_curve25519xsalsa20poly1305_seedbytes();

    public static final native int crypto_box_curve25519xsalsa20poly1305_zerobytes();

    public static final native int crypto_box_detached(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5, byte[] bArr6);

    public static final native int crypto_box_detached_afternm(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_easy(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_easy_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_box_keypair(byte[] bArr, byte[] bArr2);

    public static final native int crypto_box_macbytes();

    public static final native int crypto_box_noncebytes();

    public static final native int crypto_box_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_open_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_box_open_detached(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5, byte[] bArr6);

    public static final native int crypto_box_open_detached_afternm(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_open_easy(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_box_open_easy_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native byte[] crypto_box_primitive();

    public static final native int crypto_box_publickeybytes();

    public static final native int crypto_box_seal(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_box_seal_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_box_sealbytes();

    public static final native int crypto_box_secretkeybytes();

    public static final native int crypto_box_seed_keypair(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_box_seedbytes();

    public static final native int crypto_box_zerobytes();

    public static final native int crypto_core_hsalsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_core_hsalsa20_constbytes();

    public static final native int crypto_core_hsalsa20_inputbytes();

    public static final native int crypto_core_hsalsa20_keybytes();

    public static final native int crypto_core_hsalsa20_outputbytes();

    public static final native int crypto_core_salsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_core_salsa20_constbytes();

    public static final native int crypto_core_salsa20_inputbytes();

    public static final native int crypto_core_salsa20_keybytes();

    public static final native int crypto_core_salsa20_outputbytes();

    public static final native int crypto_generichash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3);

    public static final native int crypto_generichash_blake2b(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3);

    public static final native int crypto_generichash_blake2b_bytes();

    public static final native int crypto_generichash_blake2b_bytes_max();

    public static final native int crypto_generichash_blake2b_bytes_min();

    public static final native int crypto_generichash_blake2b_final(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_generichash_blake2b_init(byte[] bArr, byte[] bArr2, int i, int i2);

    public static final native int crypto_generichash_blake2b_init_salt_personal(byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_generichash_blake2b_keybytes();

    public static final native int crypto_generichash_blake2b_keybytes_max();

    public static final native int crypto_generichash_blake2b_keybytes_min();

    public static final native int crypto_generichash_blake2b_personalbytes();

    public static final native int crypto_generichash_blake2b_salt_personal(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_generichash_blake2b_saltbytes();

    public static final native int crypto_generichash_blake2b_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_generichash_bytes();

    public static final native int crypto_generichash_bytes_max();

    public static final native int crypto_generichash_bytes_min();

    public static final native int crypto_generichash_final(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_generichash_init(byte[] bArr, byte[] bArr2, int i, int i2);

    public static final native int crypto_generichash_keybytes();

    public static final native int crypto_generichash_keybytes_max();

    public static final native int crypto_generichash_keybytes_min();

    public static final native byte[] crypto_generichash_primitive();

    public static final native int crypto_generichash_statebytes();

    public static final native int crypto_generichash_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_hash_sha256(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_hash_sha256_bytes();

    public static final native int crypto_hash_sha256_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_hash_sha256_init(byte[] bArr);

    public static final native int crypto_hash_sha256_statebytes();

    public static final native int crypto_hash_sha256_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_hash_sha512(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_hash_sha512_bytes();

    public static final native int crypto_hash_sha512_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_hash_sha512_init(byte[] bArr);

    public static final native int crypto_hash_sha512_statebytes();

    public static final native int crypto_hash_sha512_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_onetimeauth(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_onetimeauth_bytes();

    public static final native int crypto_onetimeauth_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_onetimeauth_init(byte[] bArr, byte[] bArr2);

    public static final native int crypto_onetimeauth_keybytes();

    public static final native int crypto_onetimeauth_poly1305(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_onetimeauth_poly1305_bytes();

    public static final native int crypto_onetimeauth_poly1305_final(byte[] bArr, byte[] bArr2);

    public static final native int crypto_onetimeauth_poly1305_init(byte[] bArr, byte[] bArr2);

    public static final native int crypto_onetimeauth_poly1305_keybytes();

    public static final native int crypto_onetimeauth_poly1305_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_onetimeauth_poly1305_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native byte[] crypto_onetimeauth_primitive();

    public static final native int crypto_onetimeauth_statebytes();

    public static final native int crypto_onetimeauth_update(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_onetimeauth_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_pwhash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, int i5);

    public static final native int crypto_pwhash_alg_argon2i13();

    public static final native int crypto_pwhash_alg_default();

    public static final native int crypto_pwhash_bytes_max();

    public static final native int crypto_pwhash_bytes_min();

    public static final native int crypto_pwhash_memlimit_interactive();

    public static final native int crypto_pwhash_memlimit_max();

    public static final native int crypto_pwhash_memlimit_min();

    public static final native int crypto_pwhash_memlimit_moderate();

    public static final native int crypto_pwhash_memlimit_sensitive();

    public static final native int crypto_pwhash_opslimit_interactive();

    public static final native int crypto_pwhash_opslimit_max();

    public static final native int crypto_pwhash_opslimit_min();

    public static final native int crypto_pwhash_opslimit_moderate();

    public static final native int crypto_pwhash_opslimit_sensitive();

    public static final native int crypto_pwhash_passwd_max();

    public static final native int crypto_pwhash_passwd_min();

    public static final native byte[] crypto_pwhash_primitive();

    public static final native int crypto_pwhash_saltbytes();

    public static final native int crypto_pwhash_str(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static final native int crypto_pwhash_str_verify(byte[] bArr, byte[] bArr2, int i);

    public static final native int crypto_pwhash_strbytes();

    public static final native byte[] crypto_pwhash_strprefix();

    public static final native int crypto_scalarmult(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_scalarmult_base(byte[] bArr, byte[] bArr2);

    public static final native int crypto_scalarmult_bytes();

    public static final native int crypto_scalarmult_curve25519(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_scalarmult_curve25519_base(byte[] bArr, byte[] bArr2);

    public static final native int crypto_scalarmult_curve25519_bytes();

    public static final native int crypto_scalarmult_curve25519_scalarbytes();

    public static final native byte[] crypto_scalarmult_primitive();

    public static final native int crypto_scalarmult_scalarbytes();

    public static final native int crypto_secretbox_boxzerobytes();

    public static final native int crypto_secretbox_detached(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_secretbox_easy(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_secretbox_keybytes();

    public static final native int crypto_secretbox_macbytes();

    public static final native int crypto_secretbox_noncebytes();

    public static final native int crypto_secretbox_open_detached(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte[] bArr5);

    public static final native int crypto_secretbox_open_easy(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native byte[] crypto_secretbox_primitive();

    public static final native int crypto_secretbox_xsalsa20poly1305(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_secretbox_xsalsa20poly1305_boxzerobytes();

    public static final native int crypto_secretbox_xsalsa20poly1305_keybytes();

    public static final native int crypto_secretbox_xsalsa20poly1305_macbytes();

    public static final native int crypto_secretbox_xsalsa20poly1305_noncebytes();

    public static final native int crypto_secretbox_xsalsa20poly1305_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_secretbox_xsalsa20poly1305_zerobytes();

    public static final native int crypto_secretbox_zerobytes();

    public static final native int crypto_shorthash(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_shorthash_bytes();

    public static final native int crypto_shorthash_keybytes();

    public static final native byte[] crypto_shorthash_primitive();

    public static final native int crypto_shorthash_siphash24(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_shorthash_siphash24_bytes();

    public static final native int crypto_shorthash_siphash24_keybytes();

    public static final native int crypto_sign(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_sign_bytes();

    public static final native int crypto_sign_detached(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_sign_ed25519(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_sign_ed25519_bytes();

    public static final native int crypto_sign_ed25519_detached(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_sign_ed25519_keypair(byte[] bArr, byte[] bArr2);

    public static final native int crypto_sign_ed25519_open(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_sign_ed25519_pk_to_curve25519(byte[] bArr, byte[] bArr2);

    public static final native int crypto_sign_ed25519_publickeybytes();

    public static final native int crypto_sign_ed25519_secretkeybytes();

    public static final native int crypto_sign_ed25519_seed_keypair(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_sign_ed25519_seedbytes();

    public static final native int crypto_sign_ed25519_sk_to_curve25519(byte[] bArr, byte[] bArr2);

    public static final native int crypto_sign_ed25519_sk_to_pk(byte[] bArr, byte[] bArr2);

    public static final native int crypto_sign_ed25519_sk_to_seed(byte[] bArr, byte[] bArr2);

    public static final native int crypto_sign_ed25519_verify_detached(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_sign_keypair(byte[] bArr, byte[] bArr2);

    public static final native int crypto_sign_open(byte[] bArr, int[] iArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native byte[] crypto_sign_primitive();

    public static final native int crypto_sign_publickeybytes();

    public static final native int crypto_sign_secretkeybytes();

    public static final native int crypto_sign_seed_keypair(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_sign_seedbytes();

    public static final native int crypto_sign_verify_detached(byte[] bArr, byte[] bArr2, int i, byte[] bArr3);

    public static final native int crypto_stream_chacha20(byte[] bArr, int i, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_stream_chacha20_ietf(byte[] bArr, int i, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_stream_chacha20_ietf_noncebytes();

    public static final native int crypto_stream_chacha20_ietf_xor(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_stream_chacha20_ietf_xor_ic(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4);

    public static final native int crypto_stream_chacha20_keybytes();

    public static final native int crypto_stream_chacha20_noncebytes();

    public static final native int crypto_stream_chacha20_xor(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_stream_chacha20_xor_ic(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4);

    public static final native int crypto_stream_salsa20(byte[] bArr, int i, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_stream_salsa20_keybytes();

    public static final native int crypto_stream_salsa20_noncebytes();

    public static final native int crypto_stream_salsa20_xor(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_stream_salsa20_xor_ic(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4);

    public static final native int crypto_stream_xsalsa20(byte[] bArr, int i, byte[] bArr2, byte[] bArr3);

    public static final native int crypto_stream_xsalsa20_keybytes();

    public static final native int crypto_stream_xsalsa20_noncebytes();

    public static final native int crypto_stream_xsalsa20_xor(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4);

    public static final native int crypto_stream_xsalsa20_xor_ic(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2, byte[] bArr4);

    public static final native void randombytes(byte[] bArr, int i);

    public static final native void randombytes_buf(byte[] bArr, int i);

    public static final native int randombytes_close();

    public static final native int randombytes_random();

    public static final native void randombytes_stir();

    public static final native int randombytes_uniform(int i);

    public static final native void sodium_increment(byte[] bArr, int i);

    public static final native int sodium_init();

    public static final native byte[] sodium_version_string();
}
