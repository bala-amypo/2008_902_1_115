@PostMapping("/login")
public AuthResponse login(@RequestBody LoginRequest request) {

    User user = userService.findByEmail(request.getEmail());

    String token = jwtUtil.generateToken(
            user.getId(),
            user.getEmail(),
            user.getRole()
    );

    return new AuthResponse(
            token,
            user.getId(),
            user.getEmail(),
            user.getRole()
    );
}
