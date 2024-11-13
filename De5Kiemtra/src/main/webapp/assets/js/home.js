const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");

let w = canvas.width = window.innerWidth;
let h = canvas.height = window.innerHeight;
const { sin, cos, PI, hypot, min, max } = Math;

function spawn() {
    const pts = Array.from({ length: 333 }, () => ({
        x: rnd(innerWidth),
        y: rnd(innerHeight),
        len: 0,
        r: 0,
    }));

    const pts2 = Array.from({ length: 9 }, (_, i) => ({
        x: cos((i / 9) * PI * 2),
        y: sin((i / 9) * PI * 2),
    }));

    let seed = rnd(100);
    let tx = rnd(innerWidth);
    let ty = rnd(innerHeight);
    let x = rnd(innerWidth);
    let y = rnd(innerHeight);
    let kx = rnd(0.8, 0.8);
    let ky = rnd(0.8, 0.8);
    let walkRadius = pt(rnd(50, 50), rnd(50, 50));
    let r = innerWidth / rnd(100, 150);

    function paintPt(pt) {
        pts2.forEach((pt2) => {
            if (!pt.len) return;
            drawLine(
                lerp(x + pt2.x * r, pt.x, pt.len * pt.len),
                lerp(y + pt2.y * r, pt.y, pt.len * pt.len),
                x + pt2.x * r,
                y + pt2.y * r
            );
        });
        drawCircle(pt.x, pt.y, pt.r);
    }

    return {
        follow(x, y) {
            tx = x;
            ty = y;
        },

        tick(t) {
            const selfMoveX = cos(t * kx + seed) * walkRadius.x;
            const selfMoveY = sin(t * ky + seed) * walkRadius.y;
            let fx = tx + selfMoveX;
            let fy = ty + selfMoveY;

            x += min(innerWidth / 100, (fx - x) / 10);
            y += min(innerWidth / 100, (fy - y) / 10);

            let i = 0;
            pts.forEach((pt) => {
                const dx = pt.x - x,
                    dy = pt.y - y;
                const len = hypot(dx, dy);
                let r = min(2, innerWidth / len / 5);
                pt.t = 0;
                const increasing = len < innerWidth / 10 && i++ < 8;
                let dir = increasing ? 0.1 : -0.1;
                if (increasing) {
                    r *= 1.5;
                }
                pt.r = r;
                pt.len = max(0, min(pt.len + dir, 1));
                paintPt(pt);
            });
        },
    };
}

const spiders = Array.from({ length: 2 }, spawn);

addEventListener("pointermove", (e) => {
    spiders.forEach((spider) => {
        spider.follow(e.clientX, e.clientY);
    });
});

function draw() {
    ctx.fillStyle = "#000";
    ctx.fillRect(0, 0, w, h); // Clear canvas with black background
    const t = performance.now() / 1000;
    ctx.fillStyle = ctx.strokeStyle = "#fff";
    spiders.forEach((spider) => spider.tick(t));
    requestAnimationFrame(draw);
}

draw();

function rnd(x = 1, dx = 0) {
    return Math.random() * x + dx;
}

function drawCircle(x, y, r) {
    ctx.beginPath();
    ctx.ellipse(x, y, r, r, 0, 0, PI * 2);
    ctx.fill();
}

function drawLine(x0, y0, x1, y1) {
    ctx.beginPath();
    ctx.moveTo(x0, y0);

    for (let i = 0; i < 100; i++) {
        const progress = (i + 1) / 100;
        let x = lerp(x0, x1, progress);
        let y = lerp(y0, y1, progress);
        let offset = noise(x / 5 + x0, y / 5 + y0) * 2;
        ctx.lineTo(x + offset, y + offset);
    }

    ctx.stroke();
}

function lerp(a, b, t) {
    return a + (b - a) * t;
}

function noise(x, y, t = 101) {
    let w0 = sin(0.3 * x + 1.4 * t + 2.0 + 2.5 * sin(0.4 * y - 1.3 * t));
    let w1 = sin(0.2 * y + 1.5 * t + 2.8 + 2.3 * sin(0.5 * x - 1.2 * t));
    return w0 + w1;
}

function pt(x, y) {
    return { x, y };
}